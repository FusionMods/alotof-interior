// Used for 26.1+ (the year.drop rebrand, not 1.21.11 - see fabric/build.gradle.kts's
// header comment) - see that file for why this one differs.

plugins {
    id("dev.architectury.loom-no-remap")
    id("architectury-plugin")
    id("com.gradleup.shadow")
    id("me.modmuss50.mod-publish-plugin") version "2.2.0"
}

val minecraft = stonecutter.current.version
val common = requireNotNull(stonecutter.node?.sibling("")?.project) { "No common project for $project" }

val modId: String by project
val modVersion: String by project

version = "$modVersion+$minecraft"
base { archivesName.set("$modId-fabric") }

architectury {
    platformSetupLoomIde()
    fabric()
}

val commonBundle: Configuration by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}
val shadowBundle: Configuration by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}
configurations {
    compileClasspath.get().extendsFrom(commonBundle)
    runtimeClasspath.get().extendsFrom(commonBundle)
    named("developmentFabric").get().extendsFrom(commonBundle)
}

repositories {
    maven("https://maven.shedaniel.me/") // Cloth Config
    // Continuity isn't published to its own maven - see the comment above the
    // continuityVersion dependency below.
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") { name = "Modrinth" } }
        filter { includeGroup("maven.modrinth") }
    }
}

// See the comment in fabric/build.gradle.kts: these live in
// versions/26.2/gradle.properties, only an ancestor of `common`.
val fabricLoaderVersion = common.property("fabricLoaderVersion") as String
val fabricApiVersion = common.property("fabricApiVersion") as String
val architecturyApiVersion = common.property("architecturyApiVersion") as String
val clothConfigVersion = common.property("clothConfigVersion") as String

dependencies {
    // No `mappings(...)` here - see the header comment above.
    minecraft("net.minecraft:minecraft:$minecraft")

    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    implementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion")
    implementation("dev.architectury:architectury-fabric:$architecturyApiVersion")

    // Optional/soft dependency: compile against it, and have it on the dev
    // run's classpath, but don't bundle it or require it at runtime - see
    // the "cloth-config" entry in fabric.mod.json.
    compileOnly("me.shedaniel.cloth:cloth-config-fabric:$clothConfigVersion")
    localRuntime("me.shedaniel.cloth:cloth-config-fabric:$clothConfigVersion")

    // Continuity: optional/soft dependency that renders the CTM (connected textures)
    // definitions gen.py writes under optifine/ctm - see the "table" optifine/ctm
    // properties files. Pulled from Modrinth's maven since Continuity doesn't publish
    // to a maven of its own.
    (common.findProperty("continuityVersion") as String?)?.let {
        localRuntime("maven.modrinth:continuity:$it")
    }

    commonBundle(project(common.path)) { isTransitive = false }
    shadowBundle(project(common.path, "transformProductionFabric")) { isTransitive = false }
}

java {
    withSourcesJar()
    val java = JavaVersion.toVersion(common.property("javaVersion") as String)
    sourceCompatibility = java
    targetCompatibility = java
    // See the toolchain comment in the root build.gradle.kts.
    toolchain.languageVersion.set(JavaLanguageVersion.of(java.majorVersion))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.processResources {
    val modName: String by project
    val modDescription: String by project
    val modAuthors: String by project
    val modLicense: String by project

    val props = mapOf(
        "mod_id" to modId,
        "mod_version" to modVersion,
        "mod_name" to modName,
        "mod_description" to modDescription,
        "mod_authors" to modAuthors,
        "mod_license" to modLicense,
        "minecraft_version" to minecraft,
        "loader_version" to fabricLoaderVersion,
    )
    inputs.properties(props)
    filesMatching("fabric.mod.json") { expand(props) }
}

// There's no remap step on this no-remap branch (see the header comment), so - unlike
// fabric/build.gradle.kts, where remapJar takes shadowJar's output and becomes the actual
// distributable - shadowJar's output has to become the distributable directly here.
tasks.shadowJar {
    configurations = listOf(shadowBundle)
    archiveClassifier.set("")
}

tasks.jar {
    archiveClassifier.set("dev")
}

tasks.build {
    group = "versioned"
    description = "Must run through 'chiseledBuild' - see stonecutter.gradle.kts"
    dependsOn(tasks.shadowJar)
}

tasks.register<Copy>("buildAndCollect") {
    group = "versioned"
    from(tasks.shadowJar.get().archiveFile, tasks.named<Jar>("sourcesJar").get().archiveFile)
    into(rootProject.layout.buildDirectory.file("libs/$modVersion/fabric"))
    dependsOn("build")
}

// Publishes this exact version+loader's jar to Modrinth/CurseForge - see
// stonecutter.gradle.kts's publishAllMods for running every variant's at once, and
// gradle.properties for the project IDs/dry-run switch this reads.
val modrinthProjectId: String by project
val curseforgeProjectId: String by project

publishMods {
    file.set(tasks.shadowJar.flatMap { it.archiveFile })
    changelog.set(providers.environmentVariable("CHANGELOG").orElse("See the commit history."))
    type.set(BETA)
    modLoaders.add("fabric")
    dryRun.set(providers.gradleProperty("publish.dryRun").map(String::toBoolean).orElse(true))

    // Skipped until a real Modrinth project ID replaces the placeholder - otherwise a
    // doomed publishModrinth (invalid project ID, no MODRINTH_TOKEN) fails the whole
    // build and stops publishCurseforge from running too.
    if (modrinthProjectId != "TODO_MODRINTH_PROJECT_ID") {
        modrinth {
            projectId.set(modrinthProjectId)
            accessToken.set(providers.environmentVariable("MODRINTH_TOKEN"))
            minecraftVersions.add(minecraft)
            environment.set(CLIENT_AND_SERVER)
        }
    }
    curseforge {
        projectId.set(curseforgeProjectId)
        accessToken.set(providers.environmentVariable("CURSEFORGE_TOKEN"))
        minecraftVersions.add(minecraft)
        client.set(true)
        server.set(true)
    }
}
