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
    # pale_oak needs Java-side registration gated to >=1.21.6 (added in 1.21.2 - see
    # ModBlocks.java/ModCreativeTabs.java/ALotOfInteriorClient.java) - cherry/bamboo have
    # existed since 1.20, so every version this project targets already has them.
    "pale_oak",
    "cherry",
    "bamboo",
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
    "pale_oak",
    "cherry",
    "bamboo",
]

# Wood types whose Java registrations need a Stonecutter version gate, and the minimum
# version each needs - kept here (not just in the Java-side generator script) since it's
# a fact about the wood itself, not about any one block type's registration code.
WOOD_TYPE_MIN_VERSION = {
    "pale_oak": "1.21.6",
}

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
        f.write(json.dumps(data))


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

def gen_chair_shared() -> None:
    # Base geometry + per-wood pieces shared by every chair style (simple/open/no_back).
    # Previously each style baked one fully-fused, fully-textured model per (leg wood, seat
    # wood) combo - 144 files each, only 2 of which (the wood textures) ever actually varied
    # per file. The geometry only varies along 2 independent axes - which wood the legs use,
    # which wood the seat/backrest uses - so it's generated once per axis value here and
    # combined per-block via a blockstate "multipart" (see _chair_multipart below), the same
    # technique gen_table() already uses for its leg/top split.
    #
    # Legs and the seat cushion are the same piece across every style - chair_open was
    # originally modelled with a different leg UV unwrap on the north face than
    # chair_simple/stool's legs, but with all 3 styles now just STYLE values on the same
    # block (cycled in place with shift-right-click), that showed up as the legs visibly
    # changing look when cycling styles, which reads as a bug rather than an intentional
    # style difference - unified onto the one shared leg piece instead.

    write_json(
        ASSETS_DIR / "models/block/base/chair_seat_core.json",
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
            ],
        },
    )

    def leg_element(from_, to_, north_uv):
        return {
            "from": from_,
            "to": to_,
            "faces": {
                "north": {"uv": north_uv, "texture": "#0"},
                "east": {"uv": [2, 10, 4, 16], "texture": "#0"},
                "south": {"uv": [8, 10, 10, 16], "texture": "#0"},
                "west": {"uv": [6, 10, 8, 16], "texture": "#0"},
                "down": {"uv": [8, 8, 6, 10], "texture": "#0", "cullface": "down"},
            },
        }

    def leg_element_inner(from_, to_, north_uv):
        # The two "inner" legs (nw/ne) share east/south/west UVs distinct from the two
        # "outer" legs (sw/se) - matches the original hand-authored models exactly.
        return {
            "from": from_,
            "to": to_,
            "faces": {
                "north": {"uv": north_uv, "texture": "#0"},
                "east": {"uv": [6, 10, 8, 16], "texture": "#0"},
                "south": {"uv": [12, 10, 14, 16], "texture": "#0"},
                "west": {"uv": [10, 10, 12, 16], "texture": "#0"},
                "down": {"uv": [12, 8, 10, 10], "texture": "#0", "cullface": "down"},
            },
        }

    write_json(
        ASSETS_DIR / "models/block/base/chair_legs_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#0"},
            "elements": [
                leg_element([3, 0, 11], [5, 6, 13], [4, 10, 6, 16]),
                leg_element([11, 0, 11], [13, 6, 13], [4, 10, 6, 16]),
                leg_element_inner([3, 0, 3], [5, 6, 5], [8, 10, 10, 16]),
                leg_element_inner([11, 0, 3], [13, 6, 5], [8, 10, 10, 16]),
            ],
        },
    )
    write_json(
        ASSETS_DIR / "models/block/base/chair_simple_backrest_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#1"},
            "elements": [
                {
                    "from": [2, 8, 12],
                    "to": [14, 19, 14],
                    "faces": {
                        "north": {"uv": [2, 3, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 3, 4, 14], "texture": "#1"},
                        "south": {"uv": [2, 3, 14, 14], "texture": "#1"},
                        "west": {"uv": [12, 3, 14, 14], "texture": "#1"},
                        "up": {"uv": [2, 11, 14, 13], "texture": "#1"}
                    },
                },
            ],
        },
    )
    
    write_json(
        ASSETS_DIR / "models/block/base/chair_tall_backrest_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#1"},
            "elements": [
                {
                    "from": [2, 8, 12],
                    "to": [14, 19+2, 14],
                    "faces": {
                        "north": {"uv": [2, 3-2, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 3-2, 4, 14], "texture": "#1"},
                        "south": {"uv": [2, 3-2, 14, 14], "texture": "#1"},
                        "west": {"uv": [12, 3-2, 14, 14], "texture": "#1"},
                        "up": {"uv": [2, 11, 14, 13], "texture": "#1"}
                    },
                },
            ],
        },
    )
    
    write_json(
        ASSETS_DIR / "models/block/base/chair_open_backrest_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#1"},
            "elements": [
                {
                    "from": [2, 8, 12],
                    "to": [4, 19, 14],
                    "faces": {
                        "north": {"uv": [12, 3, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 3, 4, 14], "texture": "#1"},
                        "south": {"uv": [2, 3, 4, 14], "texture": "#1"},
                        "west": {"uv": [12, 3, 14, 14], "texture": "#1"},
                        "up": {"uv": [12, 2, 14, 4], "texture": "#1"}
                    }
                },
                {
                    "from": [12, 8, 12],
                    "to": [14, 19, 14],
                    "faces": {
                        "north": {"uv": [2, 3, 4, 14], "texture": "#1"},
                        "east": {"uv": [2, 3, 4, 14], "texture": "#1"},
                        "south": {"uv": [12, 3, 14, 14], "texture": "#1"},
                        "west": {"uv": [12, 3, 14, 14], "texture": "#1"},
                        "up": {"uv": [2, 2, 4, 4], "texture": "#1"}
                    }
                },
                {
                    "from": [4, 17, 12],
                    "to": [12, 19, 14],
                    "faces": {
                        "north": {"uv": [4, 3, 12, 5], "texture": "#1"},
                        "south": {"uv": [4, 3, 12, 5], "texture": "#1"},
                        "up": {"uv": [4, 11, 12, 13], "texture": "#1"},
                        "down": {"uv": [4, 3, 12, 5], "texture": "#1"}
                    }
                },
                {
                    "from": [4, 12, 12],
                    "to": [12, 13, 14],
                    "faces": {
                        "north": {"uv": [4, 7, 12, 8], "texture": "#1"},
                        "south": {"uv": [4, 7, 12, 8], "texture": "#1"},
                        "up": {"uv": [4, 11, 12, 13], "texture": "#1"},
                        "down": {"uv": [4, 3, 12, 5], "texture": "#1"}
                    }
                },
            ],
        },
    )
    
    write_json(
        ASSETS_DIR / "models/block/base/chair_tall_open_backrest_core.json",
        {
            "parent": "block/block",
            "format_version": "1.9.0",
            "credit": "Made with Blockbench",
            "textures": {"particle": "#1"},
            "elements": [
                {
                    "from": [2, 8, 12],
                    "to": [4, 19+2, 14],
                    "faces": {
                        "north": {"uv": [12, 3-2, 14, 14], "texture": "#1"},
                        "east": {"uv": [2, 3-2, 4, 14], "texture": "#1"},
                        "south": {"uv": [2, 3-2, 4, 14], "texture": "#1"},
                        "west": {"uv": [12, 3-2, 14, 14], "texture": "#1"},
                        "up": {"uv": [12, 2, 14, 4], "texture": "#1"}
                    }
                },
                {
                    "from": [12, 8, 12],
                    "to": [14, 19+2, 14],
                    "faces": {
                        "north": {"uv": [2, 3-2, 4, 14], "texture": "#1"},
                        "east": {"uv": [2, 3-2, 4, 14], "texture": "#1"},
                        "south": {"uv": [12, 3-2, 14, 14], "texture": "#1"},
                        "west": {"uv": [12, 3-2, 14, 14], "texture": "#1"},
                        "up": {"uv": [2, 2, 4, 4], "texture": "#1"}
                    }
                },
                {
                    "from": [4, 17+2, 12],
                    "to": [12, 19+2, 14],
                    "faces": {
                        "north": {"uv": [4, 3, 12, 5], "texture": "#1"},
                        "south": {"uv": [4, 3, 12, 5], "texture": "#1"},
                        "up": {"uv": [4, 11, 12, 13], "texture": "#1"},
                        "down": {"uv": [4, 3, 12, 5], "texture": "#1"}
                    }
                },
                {
                    "from": [4, 12-1, 12],
                    "to": [12, 13-1, 14],
                    "faces": {
                        "north": {"uv": [4, 7-1, 12, 8-1], "texture": "#1"},
                        "south": {"uv": [4, 7-1, 12, 8-1], "texture": "#1"},
                        "up": {"uv": [4, 11, 12, 13], "texture": "#1"},
                        "down": {"uv": [4, 3, 12, 5], "texture": "#1"}
                    }
                },
                {
                    "from": [4, 12+3, 12],
                    "to": [12, 13+3, 14],
                    "faces": {
                        "north": {"uv": [4, 7+3, 12, 8+3], "texture": "#1"},
                        "south": {"uv": [4, 7+3, 12, 8+3], "texture": "#1"},
                        "up": {"uv": [4, 11, 12, 13], "texture": "#1"},
                        "down": {"uv": [4, 3, 12, 5], "texture": "#1"}
                    }
                },
            ],
        },
    )

    # Every chair style's half=upper state renders nothing (see ChairBlock's class doc) -
    # one shared empty model covers simple/open/no_back instead of one each.
    write_json(ASSETS_DIR / "models/block/base/chair_upper.json", {"elements": []})

    for wood_type in WOOD_TYPES:
        write_json(
            ASSETS_DIR / f"models/block/chair_seat_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_seat_core", "textures": {"1": f"minecraft:block/{wood_type}_planks"}},
        )
        write_json(
            ASSETS_DIR / f"models/block/chair_legs_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_legs_core", "textures": {"0": f"minecraft:block/{wood_type}_planks"}},
        )
        write_json(
            ASSETS_DIR / f"models/block/chair_simple_backrest_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_simple_backrest_core", "textures": {"1": f"minecraft:block/{wood_type}_planks"}},
        )
        write_json(
            ASSETS_DIR / f"models/block/chair_tall_backrest_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_tall_backrest_core", "textures": {"1": f"minecraft:block/{wood_type}_planks"}},
        )
        write_json(
            ASSETS_DIR / f"models/block/chair_open_backrest_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_open_backrest_core", "textures": {"1": f"minecraft:block/{wood_type}_planks"}},
        )
        write_json(
            ASSETS_DIR / f"models/block/chair_tall_open_backrest_{wood_type}.json",
            {"parent": "alotofinterior:block/base/chair_tall_open_backrest_core", "textures": {"1": f"minecraft:block/{wood_type}_planks"}},
        )


# STYLE values (must match ChairBlock.STYLE_SIMPLE/STYLE_OPEN/STYLE_NO_BACK) -> the layer
# models (already wood-resolved) that make up that style's LOWER-half appearance.
_CHAIR_STYLE_LAYERS = {
    0: lambda leg, seat: [
        f"alotofinterior:block/chair_legs_{leg}",
        f"alotofinterior:block/chair_seat_{seat}",
        f"alotofinterior:block/chair_simple_backrest_{seat}",
    ],
    1: lambda leg, seat: [
        f"alotofinterior:block/chair_legs_{leg}",
        f"alotofinterior:block/chair_seat_{seat}",
        f"alotofinterior:block/chair_tall_backrest_{seat}"
    ], 
    2: lambda leg, seat: [
        f"alotofinterior:block/chair_legs_{leg}",
        f"alotofinterior:block/chair_seat_{seat}",
        f"alotofinterior:block/chair_open_backrest_{seat}",
    ],
    3: lambda leg, seat: [
        f"alotofinterior:block/chair_legs_{leg}",
        f"alotofinterior:block/chair_seat_{seat}",
        f"alotofinterior:block/chair_tall_open_backrest_{seat}"
    ],
    4: lambda leg, seat: [
        f"alotofinterior:block/chair_legs_{leg}",
        f"alotofinterior:block/chair_seat_{seat}",
    ],
}


def _chair_blockstate(wood_type_leg: str, wood_type_seat: str) -> dict:
    # One block, one STYLE property (see ChairBlock) instead of one registered block per
    # style - so this is the only blockstate file per (leg wood, seat wood) combo, with
    # "style" joining "half"/"facing" in the multipart "when" conditions instead of style
    # being which file/block you're looking at. half=upper renders nothing regardless of
    # style, so it only needs one unconditional entry.
    multipart = []
    for style, layers_for in _CHAIR_STYLE_LAYERS.items():
        layers = layers_for(wood_type_leg, wood_type_seat)
        for facing, y in (("north", None), ("east", 90), ("south", 180), ("west", 270)):
            for model in layers:
                apply = {"model": model}
                if y:
                    apply["y"] = y
                multipart.append({"when": {"half": "lower", "facing": facing, "style": str(style)}, "apply": apply})
    multipart.append({"when": {"half": "upper"}, "apply": {"model": "alotofinterior:block/base/chair_upper"}})
    return {"multipart": multipart}


def gen_chair() -> None:
    # Full fused geometry (legs + seat + solid backrest, i.e. how style=0/STYLE_SIMPLE looks)
    # - not used for in-world rendering (that's the multipart blockstate above, sharing
    # pieces via gen_chair_shared()), but items can't be multipart, and every wood combo has
    # exactly one registered item regardless of STYLE (see ChairBlock/ModBlocks.java), so
    # this is still needed as that item model's parent.
    write_json(
        ASSETS_DIR / "models/block/base/chair_full_core.json",
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
                        "north": {"uv": [2, 2, 14, 13], "texture": "#1"},
                        "east": {"uv": [0, 5, 2, 16], "texture": "#1"},
                        "south": {"uv": [2, 1, 14, 12], "texture": "#1"},
                        "west": {"uv": [0, 5, 2, 16], "texture": "#1"},
                        "up": {"uv": [2, 0, 14, 2], "texture": "#1"}
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

    for wood_type_leg in WOOD_TYPES:
        for wood_type_seat in WOOD_TYPES:
            fused_model = f"alotofinterior:block/chair_simple_{wood_type_leg}_{wood_type_seat}"
            write_json(
                ASSETS_DIR / f"models/block/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {
                    "parent": "alotofinterior:block/base/chair_full_core",
                    "textures": {
                        "0": f"minecraft:block/{wood_type_leg}_planks",
                        "1": f"minecraft:block/{wood_type_seat}_planks",
                    },
                },
            )
            write_json(
                ASSETS_DIR / f"blockstates/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                _chair_blockstate(wood_type_leg, wood_type_seat),
            )
            write_json(
                ASSETS_DIR / f"models/item/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {"parent": fused_model},
            )
            write_json(
                ASSETS_DIR / f"items/chair_simple_{wood_type_leg}_{wood_type_seat}.json",
                {"model": {"type": "minecraft:model", "model": fused_model}},
            )


DRAWER_TYPES = ("single", "left", "middle", "right")


def _drawer_blockstate(wood_type: str) -> dict:
    # Same facing -> y-rotation multipart pattern as _chair_blockstate, keyed on "type"
    # (DrawerBlock.TYPE) instead of "style"/"half".
    multipart = []
    for drawer_type in DRAWER_TYPES:
        for facing, y in (("north", None), ("east", 90), ("south", 180), ("west", 270)):
            apply = {"model": f"alotofinterior:block/drawer_{drawer_type}_{wood_type}"}
            if y:
                apply["y"] = y
            multipart.append({"when": {"facing": facing, "type": drawer_type}, "apply": apply})
    return {"multipart": multipart}


def gen_drawer() -> None:
    # Placeholder geometry only ("elements": []) - real geometry (see drawer.json's "core"/
    # "drawers" groups) gets filled in by hand later. One base per DrawerType rather than one
    # shared base, since a left/middle/right segment (flush against a neighbor) will likely
    # end up differing from a standalone single one once real geometry lands.
    for drawer_type in DRAWER_TYPES:
        write_json(
            ASSETS_DIR / f"models/block/base/drawer_{drawer_type}_core.json",
            {
                "parent": "block/block",
                "format_version": "1.9.0",
                "credit": "Made with Blockbench",
                "textures": {"particle": "#0"},
                "elements": [
                    {
                        "from": [1, 0, 7],
                        "to": [3, 2, 9],
                        "rotation": {"angle": 0, "axis": "y", "origin": [1, 0, 7]},
                        "color": 1,
                        "faces": {
                            "north": {"uv": [13, 15, 13.5, 15.5], "texture": "#0"},
                            "east": {"uv": [12.5, 15, 13, 15.5], "texture": "#0"},
                            "south": {"uv": [14, 15, 14.5, 15.5], "texture": "#0"},
                            "west": {"uv": [13.5, 15, 14, 15.5], "texture": "#0"},
                            "up": {"uv": [13.5, 15, 13, 14.5], "texture": "#0"},
                            "down": {"uv": [14, 14.5, 13.5, 15], "texture": "#0"}
                        }
                    },
                    {
                        "from": [13, 0, 7],
                        "to": [15, 2, 9],
                        "rotation": {"angle": 0, "axis": "y", "origin": [13, 0, 7]},
                        "color": 1,
                        "faces": {
                            "north": {"uv": [11, 15, 11.5, 15.5], "texture": "#0"},
                            "east": {"uv": [10.5, 15, 11, 15.5], "texture": "#0"},
                            "south": {"uv": [12, 15, 12.5, 15.5], "texture": "#0"},
                            "west": {"uv": [11.5, 15, 12, 15.5], "texture": "#0"},
                            "up": {"uv": [11.5, 15, 11, 14.5], "texture": "#0"},
                            "down": {"uv": [12, 14.5, 11.5, 15], "texture": "#0"}
                        }
                    },
                    {
                        "from": [1, 0, 13],
                        "to": [3, 2, 15],
                        "rotation": {"angle": 0, "axis": "y", "origin": [1, 0, 13]},
                        "color": 1,
                        "faces": {
                            "north": {"uv": [13, 14, 13.5, 14.5], "texture": "#0"},
                            "east": {"uv": [12.5, 14, 13, 14.5], "texture": "#0"},
                            "south": {"uv": [14, 14, 14.5, 14.5], "texture": "#0"},
                            "west": {"uv": [13.5, 14, 14, 14.5], "texture": "#0"},
                            "up": {"uv": [13.5, 14, 13, 13.5], "texture": "#0"},
                            "down": {"uv": [14, 13.5, 13.5, 14], "texture": "#0"}
                        }
                    },
                    {
                        "from": [13, 0, 13],
                        "to": [15, 2, 15],
                        "rotation": {"angle": 0, "axis": "y", "origin": [13, 0, 13]},
                        "color": 1,
                        "faces": {
                            "north": {"uv": [11, 14, 11.5, 14.5], "texture": "#0"},
                            "east": {"uv": [10.5, 14, 11, 14.5], "texture": "#0"},
                            "south": {"uv": [12, 14, 12.5, 14.5], "texture": "#0"},
                            "west": {"uv": [11.5, 14, 12, 14.5], "texture": "#0"},
                            "up": {"uv": [11.5, 14, 11, 13.5], "texture": "#0"},
                            "down": {"uv": [12, 13.5, 11.5, 14], "texture": "#0"}
                        }
                    },
                    {
                        "from": [0, 2, 6],
                        "to": [16, 4, 16],
                        "rotation": {"angle": 0, "axis": "y", "origin": [0, 2, 6]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [2.5, 15.5, 6.5, 16], "texture": "#0"},
                            "east": {"uv": [0, 15.5, 2.5, 16], "texture": "#0"},
                            "south": {"uv": [9, 15.5, 13, 16], "texture": "#0"},
                            "west": {"uv": [6.5, 15.5, 9, 16], "texture": "#0"},
                            "up": {"uv": [6.5, 15.5, 2.5, 13], "texture": "#0"},
                            "down": {"uv": [10.5, 13, 6.5, 15.5], "texture": "#0"}
                        }
                    },
                    {
                        "from": [0, 14, 6],
                        "to": [16, 16, 16],
                        "rotation": {"angle": 0, "axis": "y", "origin": [0, 14, 6]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [2.5, 15.5, 6.5, 16], "texture": "#0"},
                            "east": {"uv": [0, 15.5, 2.5, 16], "texture": "#0"},
                            "south": {"uv": [9, 15.5, 13, 16], "texture": "#0"},
                            "west": {"uv": [6.5, 15.5, 9, 16], "texture": "#0"},
                            "up": {"uv": [6.5, 15.5, 2.5, 13], "texture": "#0"},
                            "down": {"uv": [10.5, 13, 6.5, 15.5], "texture": "#0"}
                        }
                    },
                    {
                        "from": [2, 8, 6],
                        "to": [14, 10, 15],
                        "rotation": {"angle": 0, "axis": "y", "origin": [2, 8, 6]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [11, 12.5, 8, 13], "texture": "#0"},
                            "east": {"uv": [13.25, 12.5, 11, 13], "texture": "#0"},
                            "south": {"uv": [16.25, 12.5, 13.25, 13], "texture": "#0"},
                            "west": {"uv": [8, 12.5, 5.75, 13], "texture": "#0"},
                            "up": {"uv": [8, 12.5, 11, 10.25], "texture": "#0"},
                            "down": {"uv": [11, 10.25, 14, 12.5], "texture": "#0"}
                        }
                    },
                    {
                        "from": [0, 4, 6],
                        "to": [2, 14, 16],
                        "rotation": {"angle": 0, "axis": "y", "origin": [0, 4, 6]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [2.5, 10.5, 3, 13], "texture": "#0"},
                            "east": {"uv": [0, 10.5, 2.5, 13], "texture": "#0"},
                            "south": {"uv": [5.5, 10.5, 6, 13], "texture": "#0"},
                            "west": {"uv": [3, 10.5, 5.5, 13], "texture": "#0"},
                            "up": {"uv": [3, 10.5, 2.5, 8], "texture": "#0"},
                            "down": {"uv": [3.5, 8, 3, 10.5], "texture": "#0"}
                        }
                    },
                    {
                        "from": [14, 4, 6],
                        "to": [16, 14, 16],
                        "rotation": {"angle": 0, "axis": "y", "origin": [14, 4, 6]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [2.5, 10.5, 3, 13], "texture": "#0"},
                            "east": {"uv": [0, 10.5, 2.5, 13], "texture": "#0"},
                            "south": {"uv": [5.5, 10.5, 6, 13], "texture": "#0"},
                            "west": {"uv": [3, 10.5, 5.5, 13], "texture": "#0"},
                            "up": {"uv": [3, 10.5, 2.5, 8], "texture": "#0"},
                            "down": {"uv": [3.5, 8, 3, 10.5], "texture": "#0"}
                        }
                    },
                    {
                        "from": [2, 4, 15],
                        "to": [14, 14, 16],
                        "rotation": {"angle": 0, "axis": "y", "origin": [2, 4, 15]},
                        "color": 0,
                        "faces": {
                            "north": {"uv": [12.75, 7.75, 9.75, 10.25], "texture": "#0"},
                            "east": {"uv": [13, 7.75, 12.75, 10.25], "texture": "#0"},
                            "south": {"uv": [16, 7.75, 13, 10.25], "texture": "#0"},
                            "west": {"uv": [9.75, 7.75, 9.5, 10.25], "texture": "#0"},
                            "up": {"uv": [9.75, 7.75, 12.75, 7.5], "texture": "#0"},
                            "down": {"uv": [12.75, 7.5, 15.75, 7.75], "texture": "#0"}
                        }
                    }
                ],
            },
        )

    for wood_type in WOOD_TYPES:
        for drawer_type in DRAWER_TYPES:
            write_json(
                ASSETS_DIR / f"models/block/drawer_{drawer_type}_{wood_type}.json",
                {
                    "parent": f"alotofinterior:block/base/drawer_{drawer_type}_core",
                    "textures": {"0": f"minecraft:block/{wood_type}_planks"},
                },
            )

        write_json(ASSETS_DIR / f"blockstates/drawer_{wood_type}.json", _drawer_blockstate(wood_type))

        item_parent = f"alotofinterior:block/drawer_single_{wood_type}"
        write_json(ASSETS_DIR / f"models/item/drawer_{wood_type}.json", {"parent": item_parent})
        write_json(
            ASSETS_DIR / f"items/drawer_{wood_type}.json",
            {"model": {"type": "minecraft:model", "model": item_parent}},
        )


# --- Lang ------------------------------------------------------------------------
#
# Placeholder-only: every key a block/creative tab actually needs, mapped to "" for
# now rather than guessed display text - real wording gets filled in by hand later.
# Not era-split like recipes/ - the lang JSON format itself hasn't changed, and an
# unused key for a version-gated block (pale_oak below 1.21.6) is as harmless here as
# its already-unconditional blockstate/model files are.
LANG_DIR = ASSETS_DIR / "lang"
LANG_LOCALES = ("en_us", "de_de")


def lang_keys() -> list:
    keys = ["itemGroup.alotofinterior"]
    for leg_wood in WOOD_TYPES:
        for seat_wood in WOOD_TYPES:
            keys.append(f"block.alotofinterior.chair_simple_{leg_wood}_{seat_wood}")
    for leg_wood in WOOD_TYPES:
        for top_type in TOP_TYPES:
            keys.append(f"block.alotofinterior.table_{leg_wood}_{top_type}")
    for wood_type in WOOD_TYPES:
        keys.append(f"block.alotofinterior.drawer_{wood_type}")
    return keys


def gen_lang() -> None:
    LANG_DIR.mkdir(parents=True, exist_ok=True)
    keys = sorted(set(lang_keys()))
    for locale in LANG_LOCALES:
        path = LANG_DIR / f"{locale}.json"
        existing = {}
        if path.exists():
            with open(path, encoding="utf-8") as f:
                existing = json.load(f)

        # Hand-written translations always win over "" - only fill in keys that
        # aren't there yet. Keys gen.py no longer computes (e.g. a renamed/removed
        # block) are left alone too, rather than silently discarding that work.
        translations = {key: existing.get(key, "") for key in keys}
        for key, value in existing.items():
            translations.setdefault(key, value)

        with open(path, "w", encoding="utf-8") as f:
            json.dump(translations, f, indent=2, sort_keys=True, ensure_ascii=False)
            f.write("\n")


# --- Recipes -------------------------------------------------------------------
#
# Minecraft's recipe JSON schema isn't stable across this project's targeted
# versions - verified directly against the vanilla recipes each version's own jar
# ships (e.g. data/minecraft/recipe(s)/dark_oak_fence.json and hay_block.json),
# not assumed:
#   - the data pack folder itself renamed data/<ns>/recipes/ -> data/<ns>/recipe/
#     between 1.20.4 and 1.21.1;
#   - the "result" object's item-reference key renamed "item" -> "id" at that same
#     boundary;
#   - ingredients flattened from {"item": "..."}/{"tag": "..."} objects to a bare
#     item id string (or "#"+id for a tag) between 1.21.1 and 1.21.6 - confirmed via
#     Ingredient.class itself, whose old ItemValue/TagValue representation is gone
#     entirely by 1.21.6, so this isn't optional back-compat, it's a hard break.
# These three shape changes land on exactly the "API-shape eras" settings.gradle.kts
# already tracks (1.20.1/.2/.4 = "legacy"; 1.21.1 alone = "mid"; 1.21.6+ = "modern"),
# so this generates one output folder per era; each common project's own
# build.gradle.kts/build.26.gradle.kts picks the right one at build time via
# stonecutter.eval(...), the same version comparison already used for the `//? if`
# Java comments.
RECIPE_ERAS = ("legacy", "mid", "modern")


def era_recipe_dir(era: str) -> Path:
    folder = "recipes" if era == "legacy" else "recipe"
    return REPO_ROOT / f"recipes/{era}/data/alotofinterior/{folder}"


def era_supports_wood(era: str, wood_type: str) -> bool:
    min_version = WOOD_TYPE_MIN_VERSION.get(wood_type)
    if min_version is None:
        return True
    if min_version != "1.21.6":
        raise ValueError(f"No recipe-era gating rule for min_version {min_version!r}")
    return era == "modern"


def recipe_ingredient(era: str, item_id: str):
    # Flattened to a bare string on "modern" (1.21.6+); "legacy"/"mid" both still
    # need the old {"item": "..."} object - see the header comment above.
    return item_id if era == "modern" else {"item": item_id}


def recipe_result(era: str, item_id: str, count: int) -> dict:
    # "item" only on "legacy" (1.20.x); "mid"/"modern" both renamed it to "id".
    key = "item" if era == "legacy" else "id"
    return {key: item_id, "count": count}


def shapeless_recipe(era: str, inputs: list, result_id: str, result_count: int, group: str) -> dict:
    # Shapeless recipes have no per-ingredient count field - needing N of the same
    # item means listing that same ingredient N times in the flat array (verified
    # against vanilla's own hay_block.json: 9 repeated "minecraft:wheat" entries).
    ingredients = []
    for item_id, count in inputs:
        ingredients.extend([recipe_ingredient(era, item_id)] * count)
    return {
        "type": "minecraft:crafting_shapeless",
        "group": group,
        "ingredients": ingredients,
        "result": recipe_result(era, result_id, result_count),
    }


def table_top_ingredient(top_type: str) -> str:
    # Wood top types are planks; every other TOP_TYPES entry (glass/stained glass)
    # is already a real vanilla block id on its own - see top_textures() above.
    if top_type in WOOD_TYPES:
        return f"minecraft:{top_type}_planks"
    return f"minecraft:{top_type}"


def gen_recipes() -> None:
    for era in RECIPE_ERAS:
        out_dir = era_recipe_dir(era)

        # Chair: every leg wood gets its own fence, independent of the seat wood -
        # the full leg x seat matrix, matching every combo gen_chair() already
        # builds a block for.
        for leg_wood in WOOD_TYPES:
            if not era_supports_wood(era, leg_wood):
                continue
            for seat_wood in WOOD_TYPES:
                if not era_supports_wood(era, seat_wood):
                    continue
                write_json(
                    out_dir / f"chair_simple_{leg_wood}_{seat_wood}.json",
                    shapeless_recipe(
                        era,
                        [(f"minecraft:{seat_wood}_planks", 2), (f"minecraft:{leg_wood}_fence", 2)],
                        f"alotofinterior:chair_simple_{leg_wood}_{seat_wood}",
                        4,
                        "alotofinterior:chair_simple",
                    ),
                )

        # Table: every leg wood gets its own fence, independent of the top - the
        # full leg x top matrix (top may be a wood plank type or a glass/stained
        # glass type; table_top_ingredient() picks the right vanilla block either
        # way).
        for leg_wood in WOOD_TYPES:
            if not era_supports_wood(era, leg_wood):
                continue
            for top_type in TOP_TYPES:
                if not era_supports_wood(era, top_type):
                    continue
                write_json(
                    out_dir / f"table_{leg_wood}_{top_type}.json",
                    shapeless_recipe(
                        era,
                        [(table_top_ingredient(top_type), 2), (f"minecraft:{leg_wood}_fence", 2)],
                        f"alotofinterior:table_{leg_wood}_{top_type}",
                        2,
                        "alotofinterior:table",
                    ),
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
        for file in (ASSETS_DIR / subdir).glob("chair_*"):
            file.unlink()
        for file in (ASSETS_DIR / subdir).glob("drawer_*"):
            file.unlink()
    for era in RECIPE_ERAS:
        out_dir = era_recipe_dir(era)
        out_dir.mkdir(parents=True, exist_ok=True)
        for file in out_dir.glob("table_*"):
            file.unlink()
        for file in out_dir.glob("chair_*"):
            file.unlink()

    gen_table()
    gen_chair_shared()
    gen_chair()
    gen_drawer()
    gen_lang()
    gen_recipes()
