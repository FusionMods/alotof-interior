#!/usr/bin/env python3

import json
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent
ASSETS_DIR = REPO_ROOT / "src/main/resources/assets/alotofinterior"

WOOD_TYPES = [
    "oak",
    #"spruce",
    #"birch",
    #"jungle",
    #"acacia",
    #"dark_oak",
    #"mangrove",
    #"crimson",
    #"warped",
]
TOP_TYPES = [
    "glass",
    "white_stained_glass",
    "light_gray_stained_glass",
    "gray_stained_glass",
    "black_stained_glass",
    "brown_stained_glass",
    "red_stained_glass",
    "orange_stained_glass",
    "yellow_stained_glass",
    "lime_stained_glass",
    "green_stained_glass",
    "cyan_stained_glass",
    "light_blue_stained_glass",
    "blue_stained_glass",
    "purple_stained_glass",
    "magenta_stained_glass",
    "pink_stained_glass",
    "oak",
    "spruce",
    "birch",
    "jungle",
    "acacia",
    "dark_oak",
    "mangrove",
    "crimson",
    "warped",
]

# Table is always 3/4 of a block tall: legs from y=0 to y=10, top slab from y=10 to y=12.
LEG_TOP_Y = 10
TABLE_TOP_Y = 12

DIRECTIONS = ("north", "east", "south", "west")

# Corner name -> (from, to, the two outer faces that should cull against a neighbour).
CORNERS = {
    "nw": {"from": [0, 0, 0], "to": [2, LEG_TOP_Y, 2], "cull": ("north", "west")},
    "ne": {"from": [14, 0, 0], "to": [16, LEG_TOP_Y, 2], "cull": ("north", "east")},
    "se": {"from": [14, 0, 14], "to": [16, LEG_TOP_Y, 16], "cull": ("south", "east")},
    "sw": {"from": [0, 0, 14], "to": [2, LEG_TOP_Y, 16], "cull": ("south", "west")},
}

# Corner name -> the two BooleanProperty names (in TableBlock) that must both be
# false for that corner's leg to be shown - a connected table on either of a
# corner's two sides means that corner no longer needs its own leg.
CORNER_SIDES = {
    "nw": ("north", "west"),
    "ne": ("north", "east"),
    "se": ("south", "east"),
    "sw": ("south", "west"),
}


def write_json(path: Path, data: dict) -> None:
    with open(path, "w") as f:
        f.write(json.dumps(data, indent=4))


def top_core_element() -> dict:
    # Just the flat slab surface - no side faces, so it never needs to react to
    # neighbouring tables. The rim/trim faces that used to live on this same element
    # are split out into top_trim_element() below so each one can be independently
    # omitted via the blockstate's "multipart" "when" conditions - two connected
    # tables both drop their touching trim face, leaving one continuous surface
    # instead of a doubled-up seam.
    return {
        "from": [0, LEG_TOP_Y, 0],
        "to": [16, TABLE_TOP_Y, 16],
        "faces": {
            "up": {"uv": [0, 0, 16, 16], "texture": "#0"},
            "down": {"uv": [0, 0, 16, 16], "texture": "#0"},
        },
    }


def top_trim_element(direction: str) -> dict:
    return {
        "from": [0, LEG_TOP_Y, 0],
        "to": [16, TABLE_TOP_Y, 16],
        "faces": {
            direction: {"uv": [7, 0, 9, 16], "rotation": 90, "texture": "#1"},
        },
    }


def leg_element(corner: str) -> dict:
    data = CORNERS[corner]
    faces = {}
    for direction in ("north", "east", "south", "west"):
        face = {"uv": [0, 6, 2, 16], "texture": "#2"}
        if direction in data["cull"]:
            face["cullface"] = direction
        faces[direction] = face
    faces["up"] = {"uv": [0, 0, 2, 2], "texture": "#2"}
    faces["down"] = {"uv": [0, 0, 2, 2], "texture": "#2"}
    return {"from": data["from"], "to": data["to"], "faces": faces}


def top_textures(top_type: str) -> dict:
    if "stained_glass" in top_type:
        color = top_type[: top_type.find("_s")]
        return {
            "0": f"minecraft:block/{color}_stained_glass",
            "1": f"minecraft:block/{color}_stained_glass_pane_top",
        }
    if top_type == "glass":
        return {"0": "minecraft:block/glass", "1": "minecraft:block/glass_pane_top"}
    return {"0": f"minecraft:block/{top_type}_planks", "1": f"minecraft:block/{top_type}_planks"}


def render_type_for(top_type: str) -> str:
    if top_type == "glass":
        return "cutout"
    if "stained_glass" in top_type:
        return "translucent"
    return "solid"


# Continuity ships its own optional, player-enabled "Default Connected Textures"
# resource pack (Options -> Resource Packs) with full 47-tile connected-glass art,
# colour-matched to every vanilla stained glass colour plus plain glass - see
# assets/continuity/optifine/ctm/default/glass/<folder>/0.png..46.png in Continuity's
# jar. Point our glass-type table tops at that art directly instead of a <default>
# placeholder: real connected glass with no art of our own needed. If the player
# doesn't have that pack enabled, Continuity just leaves the top face looking normal
# (a missing-sprite tile falls through to the block's own texture, not a crash).
CONTINUITY_GLASS_FOLDERS = {
    "glass": "standard",
    "white_stained_glass": "white",
    "light_gray_stained_glass": "light_gray",
    "gray_stained_glass": "gray",
    "black_stained_glass": "black",
    "brown_stained_glass": "brown",
    "red_stained_glass": "red",
    "orange_stained_glass": "orange",
    "yellow_stained_glass": "yellow",
    "lime_stained_glass": "lime",
    "green_stained_glass": "green",
    "cyan_stained_glass": "cyan",
    "light_blue_stained_glass": "light_blue",
    "blue_stained_glass": "blue",
    "purple_stained_glass": "purple",
    "magenta_stained_glass": "magenta",
    "pink_stained_glass": "pink",
}


def ctm_properties(wood_type: str, top_type: str) -> str:
    folder = CONTINUITY_GLASS_FOLDERS.get(top_type)
    if folder is not None:
        base = f"continuity:optifine/ctm/default/glass/{folder}"
        tiles = " ".join(f"{base}/{i}" for i in range(47))
    else:
        # Placeholder scaffold: every one of the 47 standard CTM positions falls back
        # to <default> (the block's normal, unconnected texture), so this is a real,
        # working CTM definition from the moment it's generated - Continuity connects
        # same-block neighbours correctly, it just doesn't look any different yet. To
        # art it in later, drop e.g. "12.png" next to this file and swap that
        # position's "<default>" for "12". See
        # https://github.com/sp614x/optifine/blob/master/OptiFineDoc/doc/ctm.properties
        # for what each of the 47 positions represents.
        tiles = " ".join(["<default>"] * 47)
    return (
        f"matchBlocks=alotofinterior:table_{wood_type}_{top_type}\n"
        "method=ctm\n"
        "faces=top\n"
        "connect=block\n"
        "innerSeams=false\n"
        f"tiles={tiles}\n"
    )


def gen_table() -> None:
    (ASSETS_DIR / "models/block").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "models/block/base").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "blockstates").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "models/item").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "items").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "optifine/ctm/table").mkdir(parents=True, exist_ok=True)

    for subdir in ("models/block/base", "blockstates", "models/item", "models/block", "items", "optifine/ctm/table"):
        for file in (ASSETS_DIR / subdir).glob("table_*"):
            file.unlink()

    # Shared geometry-only base parts. The blockstate combines these via "multipart"
    # so a corner's leg (or a trim face) can be omitted when a neighbouring table
    # already covers it; "table_full" is only for the item model, which (unlike a
    # blockstate) can't be multipart and always shows every leg and trim face.
    write_json(
        ASSETS_DIR / "models/block/base/table_top_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#0"},
            "elements": [top_core_element()],
        },
    )
    for direction in DIRECTIONS:
        write_json(
            ASSETS_DIR / f"models/block/base/table_top_trim_{direction}.json",
            {
                "parent": "block/block",
                "format_version": "1.9.0",
                "credit": "Made with Blockbench",
                "textures": {"particle": "#1"},
                "elements": [top_trim_element(direction)],
            },
        )
    for corner in CORNERS:
        write_json(
            ASSETS_DIR / f"models/block/base/table_leg_{corner}.json",
            {
                "parent": "block/block",
                "format_version": "1.9.0",
                "credit": "Made with Blockbench",
                "textures": {"particle": "#2"},
                "elements": [leg_element(corner)],
            },
        )
    write_json(
        ASSETS_DIR / "models/block/base/table_full.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#0"},
            "elements": [top_core_element()]
            + [top_trim_element(direction) for direction in DIRECTIONS]
            + [leg_element(corner) for corner in CORNERS],
        },
    )

    # One shared top model per top type (legs don't affect it, so it's wood-independent).
    for top_type in TOP_TYPES:
        textures = top_textures(top_type)
        write_json(
            ASSETS_DIR / f"models/block/table_top_core_{top_type}.json",
            {
                "parent": "alotofinterior:block/base/table_top_core",
                "render_type": render_type_for(top_type),
                "textures": {"0": textures["0"]},
            },
        )
        for direction in DIRECTIONS:
            write_json(
                ASSETS_DIR / f"models/block/table_top_trim_{direction}_{top_type}.json",
                {
                    "parent": f"alotofinterior:block/base/table_top_trim_{direction}",
                    "render_type": render_type_for(top_type),
                    "textures": {"1": textures["1"]},
                },
            )

    for wood_type in WOOD_TYPES:
        # One shared leg model per wood type per corner (top type doesn't affect legs).
        for corner in CORNERS:
            write_json(
                ASSETS_DIR / f"models/block/table_leg_{wood_type}_{corner}.json",
                {
                    "parent": f"alotofinterior:block/base/table_leg_{corner}",
                    "textures": {"2": f"minecraft:block/{wood_type}_planks"},
                },
            )

        for top_type in TOP_TYPES:
            write_json(
                ASSETS_DIR / f"models/block/table_{wood_type}_{top_type}.json",
                {
                    "parent": "alotofinterior:block/base/table_full",
                    "render_type": render_type_for(top_type),
                    "textures": {**top_textures(top_type), "2": f"minecraft:block/{wood_type}_planks"},
                },
            )

            multipart = [{"apply": {"model": f"alotofinterior:block/table_top_core_{top_type}"}}]
            for direction in DIRECTIONS:
                multipart.append(
                    {
                        "when": {direction: "false"},
                        "apply": {"model": f"alotofinterior:block/table_top_trim_{direction}_{top_type}"},
                    }
                )
            for corner, (side_a, side_b) in CORNER_SIDES.items():
                multipart.append(
                    {
                        "when": {side_a: "false", side_b: "false"},
                        "apply": {"model": f"alotofinterior:block/table_leg_{wood_type}_{corner}"},
                    }
                )
            write_json(ASSETS_DIR / f"blockstates/table_{wood_type}_{top_type}.json", {"multipart": multipart})

            write_json(
                ASSETS_DIR / f"models/item/table_{wood_type}_{top_type}.json",
                {"parent": f"alotofinterior:block/table_{wood_type}_{top_type}"},
            )
            write_json(
                ASSETS_DIR / f"items/table_{wood_type}_{top_type}.json",
                {"model": {"type": "minecraft:model", "model": f"alotofinterior:block/table_{wood_type}_{top_type}"}},
            )

            with open(ASSETS_DIR / f"optifine/ctm/table/table_{wood_type}_{top_type}.properties", "w") as f:
                f.write(ctm_properties(wood_type, top_type))


if __name__ == "__main__":
    gen_table()
