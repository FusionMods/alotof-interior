// Used for every targeted version through 1.21.11 - there is no NeoForge build for 1.20.1
// (see settings.gradle.kts) and 26.1+ (the year.drop rebrand) uses build.26.gradle.kts
// instead - see fabric/build.gradle.kts's header comment for why the cutoff is there, not
// at 1.21.11 itself.

plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("com.gradleup.shadow")
    id("me.modmuss50.mod-publish-plugin") version "2.2.0"
}

val minecraft = stonecutter.current.version
val common = requireNotNull(stonecutter.node?.sibling("")?.project) { "No common project for $project" }

val modId: String by project
val modVersion: String by project

version = "$modVersion+$minecraft"
base { archivesName.set("$modId-neoforge") }

architectury {
    platformSetupLoomIde()
    neoForge()
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
    named("developmentNeoForge").get().extendsFrom(commonBundle)
}

repositories {
    maven("https://maven.neoforged.net/releases/")
    maven("https://maven.shedaniel.me/") // Cloth Config
    // Continuity isn't published to its own maven - see the comment above the
    // continuityNeoForgeVersion dependency below.
    exclusiveContent {
        forRepository { maven("https://api.modrinth.com/maven") { name = "Modrinth" } }
        filter { includeGroup("maven.modrinth") }
    }
}

loom {
    silentMojangMappingsLicense()
}

// These live in versions/1.21.1/gradle.properties, only an ancestor of
// `common` - see the same comment in fabric/build.gradle.kts.
val neoforgeVersion = common.property("neoforgeVersion") as String
val architecturyApiVersion = common.property("architecturyApiVersion") as String
val clothConfigVersion = common.property("clothConfigVersion") as String

dependencies {
    minecraft("com.mojang:minecraft:$minecraft")
    mappings(loom.officialMojangMappings())

    "neoForge"("net.neoforged:neoforge:$neoforgeVersion")
    modImplementation("dev.architectury:architectury-neoforge:$architecturyApiVersion")

    // Optional/soft dependency: compile against it, and have it on the dev
    // run's classpath, but don't bundle it or require it at runtime - see
    // the "cloth-config" entry in neoforge.mods.toml.
    modCompileOnly("me.shedaniel.cloth:cloth-config-neoforge:$clothConfigVersion")
    modLocalRuntime("me.shedaniel.cloth:cloth-config-neoforge:$clothConfigVersion")

    // Continuity: optional/soft dependency that renders the CTM (connected textures)
    // definitions gen.py writes under optifine/ctm - see the "table" optifine/ctm
    // properties files. Only published for 1.21.1 on NeoForge (see
    // versions/1.21.1/gradle.properties), so only added when set. Pulled from
    // Modrinth's maven since Continuity doesn't publish to a maven of its own.
    // removed cause it wants fabric-api and connector
    //(common.findProperty("continuityNeoForgeVersion") as String?)?.let {
    //    modLocalRuntime("maven.modrinth:continuity:$it")
    //}

    commonBundle(project(common.path, "namedElements")) { isTransitive = false }
    shadowBundle(project(common.path, "transformProductionNeoForge")) { isTransitive = false }
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
    )
    inputs.properties(props)
    filesMatching("META-INF/neoforge.mods.toml") { expand(props) }
}

tasks.shadowJar {
    configurations = listOf(shadowBundle)
    archiveClassifier.set("dev-shadow")
    exclude("fabric.mod.json", "architectury.common.json")
}

tasks.remapJar {
    input.set(tasks.shadowJar.flatMap { it.archiveFile })
    dependsOn(tasks.shadowJar)
}

tasks.jar {
    archiveClassifier.set("dev")
}

tasks.build {
    group = "versioned"
    description = "Must run through 'chiseledBuild' - see stonecutter.gradle.kts"
}

tasks.register<Copy>("buildAndCollect") {
    group = "versioned"
    from(tasks.remapJar.get().archiveFile, tasks.remapSourcesJar.get().archiveFile)
    into(rootProject.layout.buildDirectory.file("libs/$modVersion/neoforge"))
    dependsOn("build")
}

// Publishes this exact version+loader's jar to Modrinth/CurseForge - see
// stonecutter.gradle.kts's publishAllMods for running every variant's at once, and
// gradle.properties for the project IDs/dry-run switch this reads.
val modrinthProjectId: String by project
val curseforgeProjectId: String by project

publishMods {
    file.set(tasks.remapJar.flatMap { it.archiveFile })
    changelog.set(providers.environmentVariable("CHANGELOG").orElse("See the commit history."))
    type.set(BETA)
    modLoaders.add("neoforge")
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
