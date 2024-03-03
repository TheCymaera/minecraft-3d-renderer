package com.heledron.minecraft.renderer3d.presentation

import com.heledron.minecraft.renderer3d.utilities.Color

val colorMap = HashMap<String, Color>()
.apply {
    this["acacia_log"] = Color.fromRGBA(151, 89, 55)
    this["acacia_planks"] = Color.fromRGBA(168, 90, 50)
    this["andesite"] = Color.fromRGBA(136, 136, 137)
    this["birch_log"] = Color.fromRGBA(193, 179, 135)
    this["bedrock"] = Color.fromRGBA(85, 85, 85)
    this["black_concrete"] = Color.fromRGBA(8, 10, 15)
    this["black_concrete_powder"] = Color.fromRGBA(25, 27, 32)
    this["birch_planks"] = Color.fromRGBA(192, 175, 121)
    this["black_terracotta"] = Color.fromRGBA(37, 23, 16)
    this["blue_concrete"] = Color.fromRGBA(45, 47, 143)
    this["black_wool"] = Color.fromRGBA(21, 21, 26)
    this["blue_concrete_powder"] = Color.fromRGBA(70, 73, 167)
    this["blue_ice"] = Color.fromRGBA(116, 168, 253)
    this["blue_wool"] = Color.fromRGBA(53, 57, 157)
    this["blue_terracotta"] = Color.fromRGBA(74, 60, 91)
    this["bone_block"] = Color.fromRGBA(210, 206, 179)
    this["bookshelf"] = Color.fromRGBA(117, 95, 60)
    this["bricks"] = Color.fromRGBA(151, 98, 83)
    this["brown_concrete"] = Color.fromRGBA(96, 60, 32)
    this["brown_concrete_powder"] = Color.fromRGBA(126, 85, 54)
    this["brown_mushroom_block"] = Color.fromRGBA(149, 112, 81)
    this["brown_terracotta"] = Color.fromRGBA(77, 51, 36)
    this["brown_wool"] = Color.fromRGBA(114, 72, 41)
    this["cartography_table"] = Color.fromRGBA(104, 87, 67)
    this["carved_pumpkin"] = Color.fromRGBA(150, 84, 17)
    this["chiseled_quartz_block"] = Color.fromRGBA(232, 227, 217)
    this["chiseled_red_sandstone"] = Color.fromRGBA(183, 97, 28)
    this["chiseled_sandstone"] = Color.fromRGBA(216, 203, 155)
    this["chiseled_stone_bricks"] = Color.fromRGBA(120, 119, 120)
    this["coal_block"] = Color.fromRGBA(16, 16, 16)
    this["coal_ore"] = Color.fromRGBA(116, 116, 116)
    this["coarse_dirt"] = Color.fromRGBA(119, 86, 59)
    this["cobblestone"] = Color.fromRGBA(128, 127, 128)
    this["cracked_stone_bricks"] = Color.fromRGBA(118, 118, 118)
    this["crafting_table"] = Color.fromRGBA(120, 73, 42)
    this["cut_red_sandstone"] = Color.fromRGBA(189, 102, 32)
    this["cut_sandstone"] = Color.fromRGBA(218, 206, 160)
    this["cyan_concrete"] = Color.fromRGBA(21, 119, 136)
    this["cyan_concrete_powder"] = Color.fromRGBA(37, 148, 157)
    this["cyan_terracotta"] = Color.fromRGBA(87, 91, 91)
    this["cyan_wool"] = Color.fromRGBA(21, 138, 145)
    this["dark_oak_log"] = Color.fromRGBA(65, 43, 21)
    this["dark_prismarine"] = Color.fromRGBA(52, 92, 76)
    this["diamond_block"] = Color.fromRGBA(98, 237, 228)
    this["diamond_ore"] = Color.fromRGBA(125, 143, 141)
    this["diorite"] = Color.fromRGBA(189, 188, 189)
    this["dirt"] = Color.fromRGBA(134, 96, 67)
    this["emerald_block"] = Color.fromRGBA(42, 203, 88)
    this["emerald_ore"] = Color.fromRGBA(117, 137, 124)
    this["end_stone"] = Color.fromRGBA(220, 223, 158)
    this["end_stone_bricks"] = Color.fromRGBA(218, 224, 162)
    this["fletching_table"] = Color.fromRGBA(197, 180, 133)
    this["glowstone"] = Color.fromRGBA(172, 131, 84)
    this["gold_block"] = Color.fromRGBA(246, 208, 62)
    this["gold_ore"] = Color.fromRGBA(144, 140, 125)
    this["grass_path"] = Color.fromRGBA(148, 122, 65)
    this["granite"] = Color.fromRGBA(149, 103, 86)
    this["gravel"] = Color.fromRGBA(132, 127, 127)
    this["gray_concrete"] = Color.fromRGBA(55, 58, 62)
    this["gray_concrete_powder"] = Color.fromRGBA(77, 81, 85)
    this["gray_terracotta"] = Color.fromRGBA(58, 42, 36)
    this["gray_wool"] = Color.fromRGBA(63, 68, 72)
    this["green_concrete"] = Color.fromRGBA(73, 91, 36)
    this["green_concrete_powder"] = Color.fromRGBA(97, 119, 45)
    this["green_terracotta"] = Color.fromRGBA(76, 83, 42)
    this["green_wool"] = Color.fromRGBA(85, 110, 28)
    this["hay_block"] = Color.fromRGBA(166, 139, 12)
    this["honeycomb_block"] = Color.fromRGBA(229, 148, 30)
    this["honey_block"] = Color.fromRGBA(251, 185, 53)
    this["ice"] = Color.fromRGBA(146, 184, 254)
    this["iron_block"] = Color.fromRGBA(220, 220, 220)
    this["iron_ore"] = Color.fromRGBA(136, 131, 127) //.this["jack_o_lantern"] = Color.fromRGBA(215, 152, 53)
    this["jungle_log"] = Color.fromRGBA(150, 109, 71)
    this["jungle_planks"] = Color.fromRGBA(160, 115, 81)
    this["lapis_block"] = Color.fromRGBA(31, 67, 140)
    this["lapis_ore"] = Color.fromRGBA(99, 111, 133)
    this["light_blue_concrete"] = Color.fromRGBA(36, 137, 199)
    this["light_blue_terracotta"] = Color.fromRGBA(113, 109, 138)
    this["light_blue_wool"] = Color.fromRGBA(58, 175, 217)
    this["light_blue_concrete_powder"] = Color.fromRGBA(74, 181, 213)
    this["light_gray_concrete"] = Color.fromRGBA(125, 125, 115)
    this["light_gray_concrete_powder"] = Color.fromRGBA(155, 155, 148)
    this["light_gray_terracotta"] = Color.fromRGBA(135, 107, 98)
    this["light_gray_wool"] = Color.fromRGBA(142, 142, 135)
    this["lime_terracotta"] = Color.fromRGBA(104, 118, 53)
    this["lime_wool"] = Color.fromRGBA(112, 185, 26)
    this["lime_concrete"] = Color.fromRGBA(94, 169, 25)
    this["magenta_concrete"] = Color.fromRGBA(169, 48, 159)
    this["loom"] = Color.fromRGBA(142, 119, 92)
    this["lime_concrete_powder"] = Color.fromRGBA(125, 189, 42)
    this["magenta_concrete_powder"] = Color.fromRGBA(193, 84, 185)
    this["magenta_terracotta"] = Color.fromRGBA(150, 88, 109)
    this["magenta_wool"] = Color.fromRGBA(190, 69, 180)
    this["melon"] = Color.fromRGBA(111, 145, 31)
    this["mossy_cobblestone"] = Color.fromRGBA(110, 119, 95)
    this["mossy_stone_bricks"] = Color.fromRGBA(115, 121, 105)
    this["mushroom_stem"] = Color.fromRGBA(203, 197, 186)
    this["mycelium"] = Color.fromRGBA(111, 99, 101)
    this["netherrack"] = Color.fromRGBA(98, 38, 38)
    this["nether_bricks"] = Color.fromRGBA(44, 22, 26)
    this["nether_wart_block"] = Color.fromRGBA(115, 3, 3)
    this["oak_log"] = Color.fromRGBA(151, 122, 73)
    this["nether_quartz_ore"] = Color.fromRGBA(118, 66, 62)
    this["oak_planks"] = Color.fromRGBA(162, 131, 79)
    this["observer"] = Color.fromRGBA(98, 98, 98)
    this["obsidian"] = Color.fromRGBA(15, 11, 25)
    this["orange_concrete"] = Color.fromRGBA(224, 97, 1)
    this["orange_concrete_powder"] = Color.fromRGBA(227, 132, 32)
    this["orange_terracotta"] = Color.fromRGBA(162, 84, 38)
    this["orange_wool"] = Color.fromRGBA(241, 118, 20)
    this["packed_ice"] = Color.fromRGBA(142, 180, 250)
    this["pink_concrete"] = Color.fromRGBA(214, 101, 143)
    this["pink_concrete_powder"] = Color.fromRGBA(229, 153, 181)
    this["pink_terracotta"] = Color.fromRGBA(162, 78, 79)
    this["pink_wool"] = Color.fromRGBA(238, 141, 172)
    this["podzol"] = Color.fromRGBA(92, 63, 24)
    this["polished_andesite"] = Color.fromRGBA(132, 135, 134)
    this["polished_diorite"] = Color.fromRGBA(193, 193, 195)
    this["polished_granite"] = Color.fromRGBA(154, 107, 89)
    this["prismarine_bricks"] = Color.fromRGBA(99, 172, 158)
    this["pumpkin"] = Color.fromRGBA(198, 119, 24)
    this["purple_concrete"] = Color.fromRGBA(100, 32, 156)
    this["purple_concrete_powder"] = Color.fromRGBA(132, 56, 178)
    this["purple_terracotta"] = Color.fromRGBA(118, 70, 86)
    this["purple_wool"] = Color.fromRGBA(122, 42, 173)
    this["purpur_block"] = Color.fromRGBA(170, 126, 170)
    this["purpur_pillar"] = Color.fromRGBA(171, 128, 171)
    this["quartz_pillar"] = Color.fromRGBA(235, 230, 223)
    this["redstone_block"] = Color.fromRGBA(176, 25, 5)
    this["quartz_block"] = Color.fromRGBA(236, 230, 223)
    this["redstone_lamp"] = Color.fromRGBA(95, 55, 30)
    this["redstone_ore"] = Color.fromRGBA(133, 108, 108)
    this["red_concrete"] = Color.fromRGBA(142, 33, 33)
    this["red_concrete_powder"] = Color.fromRGBA(168, 54, 51)
    this["red_nether_bricks"] = Color.fromRGBA(70, 7, 9)
    this["red_sand"] = Color.fromRGBA(191, 103, 33)
    this["red_mushroom_block"] = Color.fromRGBA(200, 47, 45)
    this["red_sandstone"] = Color.fromRGBA(181, 98, 31)
    this["red_terracotta"] = Color.fromRGBA(143, 61, 47)
    this["red_wool"] = Color.fromRGBA(161, 39, 35)
    this["sand"] = Color.fromRGBA(219, 207, 163)
    this["sandstone"] = Color.fromRGBA(224, 214, 170)
    this["scaffolding"] = Color.fromRGBA(174, 134, 80)
    this["slime_block"] = Color.fromRGBA(112, 192, 92)
    this["smithing_table"] = Color.fromRGBA(57, 59, 71)
    this["snow_block"] = Color.fromRGBA(249, 254, 254)
    this["soul_sand"] = Color.fromRGBA(81, 62, 51)
    this["sponge"] = Color.fromRGBA(196, 192, 75)
    this["spruce_log"] = Color.fromRGBA(109, 80, 47)
    this["spruce_planks"] = Color.fromRGBA(115, 85, 49)
    this["stone"] = Color.fromRGBA(126, 126, 126)
    this["stonecutter"] = Color.fromRGBA(123, 119, 111)
    this["stone_bricks"] = Color.fromRGBA(122, 122, 122)
    this["stripped_acacia_log"] = Color.fromRGBA(166, 91, 52)
    this["stripped_birch_log"] = Color.fromRGBA(191, 172, 116)
    this["stripped_dark_oak_log"] = Color.fromRGBA(66, 44, 23)
    this["stripped_jungle_log"] = Color.fromRGBA(166, 123, 82)
    this["stripped_oak_log"] = Color.fromRGBA(160, 130, 77)
    this["stripped_spruce_log"] = Color.fromRGBA(106, 80, 47)
    this["terracotta"] = Color.fromRGBA(152, 94, 68)
    this["tnt"] = Color.fromRGBA(143, 62, 54)
    this["wet_sponge"] = Color.fromRGBA(171, 181, 70)
    this["white_concrete"] = Color.fromRGBA(207, 213, 214)
    this["white_concrete_powder"] = Color.fromRGBA(226, 227, 228)
    this["white_terracotta"] = Color.fromRGBA(210, 178, 161)
    this["white_wool"] = Color.fromRGBA(234, 236, 237)
    this["yellow_concrete"] = Color.fromRGBA(241, 175, 21)
    this["yellow_concrete_powder"] = Color.fromRGBA(233, 199, 55)
    this["yellow_terracotta"] = Color.fromRGBA(186, 133, 35)
    this["yellow_wool"] = Color.fromRGBA(249, 198, 40)
}