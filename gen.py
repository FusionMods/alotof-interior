#!/usr/bin/env python3

import json
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent
ASSETS_DIR = REPO_ROOT / "src/main/resources/assets/alotofinterior"

WOOD_TYPES = [
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
TOP_TYPES = [
    "glass",
    "tinted_glass",
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

# Legs from y=0 to y=11, top slab from y=11 to y=13 - one unit taller than a plain 3/4
# block so a player sitting on a nearby stool (seat height 8) has knee clearance
# underneath instead of clipping the tabletop.
LEG_TOP_Y = 11
TABLE_TOP_Y = 13

LEG_RENDER_TOP_Y = LEG_TOP_Y

DIRECTIONS = ("north", "east", "south", "west")

# Corner name -> (from, to, the two outer faces that should cull against a neighbour).
CORNERS = {
    "nw": {"from": [0, 0, 0], "to": [2, LEG_RENDER_TOP_Y, 2], "cull": ("north", "west")},
    "ne": {"from": [14, 0, 0], "to": [16, LEG_RENDER_TOP_Y, 2], "cull": ("north", "east")},
    "se": {"from": [14, 0, 14], "to": [16, LEG_RENDER_TOP_Y, 16], "cull": ("south", "east")},
    "sw": {"from": [0, 0, 14], "to": [2, LEG_RENDER_TOP_Y, 16], "cull": ("south", "west")},
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
        face = {"uv": [0, 5, 2, 16], "texture": "#2"}
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
    if top_type == "tinted_glass":
        # No tinted glass pane exists in vanilla to source a trim texture from, so
        # (like the wood tops below) reuse the same texture for both slots.
        return {"0": "minecraft:block/tinted_glass", "1": "minecraft:block/tinted_glass"}
    return {"0": f"minecraft:block/{top_type}_planks", "1": f"minecraft:block/{top_type}_planks"}


def render_type_for(top_type: str) -> str:
    if top_type == "glass":
        return "cutout"
    if "stained_glass" in top_type or top_type == "tinted_glass":
        # Confirmed by inspecting minecraft:textures/block/tinted_glass.png directly -
        # its alpha channel only has partial values (110/200, never 0 or 255), the same
        # semi-transparent profile as stained glass, not plain glass's binary cutout.
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
    "tinted_glass": "tinted",
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

def gen_chair_simple() -> None:
    # Seat and legs are geometrically identical to stool_core.json (same box
    # coordinates/UVs) - the backrest is the only new element. Its UV is a plain full-face
    # stretch rather than a real unwrap: the source model this was based on had broken UV
    # data for this element, and since it's just sampling a generic repeating planks
    # texture (not bespoke art), an exact unwrap buys nothing visually.
    write_json(
        ASSETS_DIR / "models/block/base/chair_simple_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#1"},
            "elements": [
                {
                    "from": [2, 6, 2],
                    "to": [14, 8, 14],
                    "faces": {
                        "north": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "south": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "west": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "up": {"uv": [14, 14, 2, 2], "texture": "#1"},
                        "down": {"uv": [14, 2, 2, 14], "texture": "#1"},
                    },
                },
                {
                    "from": [2, 8, 12],
                    "to": [14, 19, 14],
                    "faces": {
                        "north": {"uv": [0, 0, 16, 16], "texture": "#1"},
                        # East/west are only 2 units deep (like the legs' 2-unit-wide side
                        # faces) and up is only 2 units deep (like the legs' 2x2 footprint) -
                        # a full 16x16 stretch squished both badly, so crop a UV rect that
                        # actually matches each face's real proportions instead.
                        "east": {"uv": [0, 5, 2, 16], "texture": "#1"},
                        "south": {"uv": [0, 0, 16, 16], "texture": "#1"},
                        "west": {"uv": [0, 5, 2, 16], "texture": "#1"},
                        "up": {"uv": [2, 0, 14, 2], "texture": "#1"},
                    },
                },
                {
                    "from": [3, 0, 11],
                    "to": [5, 6, 13],
                    "faces": {
                        "north": {"uv": [4, 10, 6, 16], "texture": "#0"},
                        "east": {"uv": [2, 10, 4, 16], "texture": "#0"},
                        "south": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "west": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "down": {"uv": [8, 8, 6, 10], "texture": "#0", "cullface": "down"},
                    },
                },
                {
                    "from": [11, 0, 11],
                    "to": [13, 6, 13],
                    "faces": {
                        "north": {"uv": [4, 10, 6, 16], "texture": "#0"},
                        "east": {"uv": [2, 10, 4, 16], "texture": "#0"},
                        "south": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "west": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "down": {"uv": [8, 8, 6, 10], "texture": "#0", "cullface": "down"},
                    },
                },
                {
                    "from": [3, 0, 3],
                    "to": [5, 6, 5],
                    "faces": {
                        "north": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "east": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "south": {"uv": [12, 10, 14, 16], "texture": "#0"},
                        "west": {"uv": [10, 10, 12, 16], "texture": "#0"},
                        "down": {"uv": [12, 8, 10, 10], "texture": "#0", "cullface": "down"},
                    },
                },
                {
                    "from": [11, 0, 3],
                    "to": [13, 6, 5],
                    "faces": {
                        "north": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "east": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "south": {"uv": [12, 10, 14, 16], "texture": "#0"},
                        "west": {"uv": [10, 10, 12, 16], "texture": "#0"},
                        "down": {"uv": [12, 8, 10, 10], "texture": "#0", "cullface": "down"},
                    },
                },
            ],
        },
    )

    # ChairSimpleBlock is a two-position "tall block" (like doors/tall flowers) since the
    # backrest overflows into the block above - the LOWER half draws the whole model
    # (already reaching up into that space visually), so the UPPER half just needs some
    # valid, empty model to point at. Shared across every wood combo since it renders nothing.
    write_json(ASSETS_DIR / "models/block/base/chair_simple_upper.json", {"elements": []})

    for wood_type_leg in WOOD_TYPES:
        for wood_type_seat in WOOD_TYPES:
            write_json(
                ASSETS_DIR / f"models/block/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {
                    "parent": "alotofinterior:block/base/chair_simple_core",
                    "textures": {
                        "0": f"minecraft:block/{wood_type_leg}_planks",
                        "1": f"minecraft:block/{wood_type_seat}_planks",
                    },
                },
            )

            # Model is authored facing north by default (backrest on the south side) -
            # the blockstate rotates it for the other three FACING values the same way
            # vanilla furnaces/anvils do. half=upper always points at the shared empty
            # model regardless of facing, since it never renders anything.
            model = f"alotofinterior:block/chair_simple_{wood_type_leg}_{wood_type_seat}"
            upper_model = "alotofinterior:block/base/chair_simple_upper"
            write_json(
                ASSETS_DIR / f"blockstates/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {
                    "variants": {
                        "facing=north,half=lower": {"model": model},
                        "facing=east,half=lower": {"model": model, "y": 90},
                        "facing=south,half=lower": {"model": model, "y": 180},
                        "facing=west,half=lower": {"model": model, "y": 270},
                        "facing=north,half=upper": {"model": upper_model},
                        "facing=east,half=upper": {"model": upper_model},
                        "facing=south,half=upper": {"model": upper_model},
                        "facing=west,half=upper": {"model": upper_model},
                    }
                },
            )
            write_json(
                ASSETS_DIR / f"models/item/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {"parent": model},
            )
            write_json(
                ASSETS_DIR / f"items/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {"model": {"type": "minecraft:model", "model": model}},
            )


def gen_stool() -> None:
    write_json(
        ASSETS_DIR / "models/block/base/stool_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#0"},
            "elements": [
                {
                    "from": [2, 6, 2],
                    "to": [14, 8, 14],
                    "rotation": {"angle": 0, "axis": "y", "origin": [2, 6, 2]},
                    "faces": {
                        "north": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "south": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "west": {"uv": [2, 12, 14, 14], "texture": "#1"},
                        "up": {"uv": [14, 14, 2, 2], "texture": "#1"},
                        "down": {"uv": [14, 2, 2, 14], "texture": "#1"}
                    }
                },
                {
                    "from": [3, 0, 11],
                    "to": [5, 6, 13],
                    "rotation": {"angle": 0, "axis": "y", "origin": [3, 0, 11]},
                    "faces": {
                        "north": {"uv": [4, 10, 6, 16], "texture": "#0"},
                        "east": {"uv": [2, 10, 4, 16], "texture": "#0"},
                        "south": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "west": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "down": {"uv": [8, 8, 6, 10], "texture": "#0", "cullface": "down"}
                    }
                },
                {
                    "from": [11, 0, 11],
                    "to": [13, 6, 13],
                    "rotation": {"angle": 0, "axis": "y", "origin": [11, 0, 11]},
                    "faces": {
                        "north": {"uv": [4, 10, 6, 16], "texture": "#0"},
                        "east": {"uv": [2, 10, 4, 16], "texture": "#0"},
                        "south": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "west": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "down": {"uv": [8, 8, 6, 10], "texture": "#0", "cullface": "down"}
                    }
                },
                {
                    "from": [3, 0, 3],
                    "to": [5, 6, 5],
                    "rotation": {"angle": 0, "axis": "y", "origin": [3, 0, 3]},
                    "faces": {
                        "north": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "east": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "south": {"uv": [12, 10, 14, 16], "texture": "#0"},
                        "west": {"uv": [10, 10, 12, 16], "texture": "#0"},
                        "down": {"uv": [12, 8, 10, 10], "texture": "#0", "cullface": "down"}
                    }
                },
                {
                    "from": [11, 0, 3],
                    "to": [13, 6, 5],
                    "rotation": {"angle": 0, "axis": "y", "origin": [11, 0, 3]},
                    "faces": {
                        "north": {"uv": [8, 10, 10, 16], "texture": "#0"},
                        "east": {"uv": [6, 10, 8, 16], "texture": "#0"},
                        "south": {"uv": [12, 10, 14, 16], "texture": "#0"},
                        "west": {"uv": [10, 10, 12, 16], "texture": "#0"},
                        "down": {"uv": [12, 8, 10, 10], "texture": "#0", "cullface": "down"}
                    }
                }
            ]
        },
    )
    
    for wood_type_leg in WOOD_TYPES:
        for wood_type_seat in WOOD_TYPES:
            write_json(
                ASSETS_DIR / f"models/block/stool_{wood_type_leg}_{wood_type_seat}.json",
                {
                    "parent": "alotofinterior:block/base/stool_core",
                    "textures": {
                        "0": f"minecraft:block/{wood_type_leg}_planks",
                        "1": f"minecraft:block/{wood_type_seat}_planks",
                    },
                },
            )
            
            # blockstate (stool doesn't have any multipart conditions, so it's just a single model with no variants)
            write_json(
                ASSETS_DIR / f"blockstates/stool_{wood_type_leg}_{wood_type_seat}.json",
                {
                    "variants": {
                        "": {"model": f"alotofinterior:block/stool_{wood_type_leg}_{wood_type_seat}"}
                    }
                },
            )
            # item model
            write_json(
                ASSETS_DIR / f"models/item/stool_{wood_type_leg}_{wood_type_seat}.json",
                {"parent": f"alotofinterior:block/stool_{wood_type_leg}_{wood_type_seat}"},
            )
            write_json(
                ASSETS_DIR / f"items/stool_{wood_type_leg}_{wood_type_seat}.json",
                {"model": {"type": "minecraft:model", "model": f"alotofinterior:block/stool_{wood_type_leg}_{wood_type_seat}"}},
            )


if __name__ == "__main__":
    (ASSETS_DIR / "models/block").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "models/block/base").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "blockstates").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "models/item").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "items").mkdir(parents=True, exist_ok=True)
    (ASSETS_DIR / "optifine/ctm/table").mkdir(parents=True, exist_ok=True)

    for subdir in ("models/block/base", "blockstates", "models/item", "models/block", "items", "optifine/ctm/table"):
        for file in (ASSETS_DIR / subdir).glob("table_*"):
            file.unlink()
        for file in (ASSETS_DIR / subdir).glob("stool_*"):
            file.unlink()
        for file in (ASSETS_DIR / subdir).glob("chair_simple_*"):
            file.unlink()
    gen_table()
    gen_stool()
    gen_chair_simple()
