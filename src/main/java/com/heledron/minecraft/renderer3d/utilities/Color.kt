package com.heledron.minecraft.renderer3d.utilities

class Color private constructor(var r: Int, var g: Int, var b: Int, var a: Int) {

    companion object {
        fun fromRGBA(r: Int, g: Int, b: Int, a: Int = 255): Color {
            return Color(r, g, b, a);
        }

        fun fromFractions(r: Double, g: Double, b: Double, a: Double): Color {
            return Color((r * 255).toInt(), (g * 255).toInt(), (b * 255).toInt(), (a * 255).toInt());
        }
    }
}