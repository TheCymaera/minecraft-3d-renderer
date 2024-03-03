package com.heledron.minecraft.renderer3d.scenes.shaders

import com.heledron.minecraft.renderer3d.utilities.Vector4
import com.heledron.minecraft.renderer3d.renderer.PixelData
import com.heledron.minecraft.renderer3d.renderer.PixelShader
import com.heledron.minecraft.renderer3d.renderer.VertexData
import com.heledron.minecraft.renderer3d.renderer.VertexShader
import com.heledron.minecraft.renderer3d.utilities.Color

object RGB2DShader {
    var vertex: VertexShader =  fun (vertex: DoubleArray): VertexData {
        if (vertex.size != 5) throw java.lang.Error("RGBAVertex shader expects exactly 5 elements")
        val x = vertex[0];
        val y = vertex[1];
        val r = vertex[2];
        val g = vertex[3];
        val b = vertex[4];

        val position = Vector4(x,y, 0.0, 1.0)
        val pixel = doubleArrayOf(r,g,b)
        return VertexData(position, pixel)
    }

    var pixel: PixelShader = fun (pixel: DoubleArray): PixelData {
        val r = pixel[0];
        val g = pixel[1];
        val b = pixel[2];

        return PixelData(Color.fromFractions(r, g, b, 1.0))
    }
}