package com.heledron.minecraft.renderer3d.scenes.shaders

import com.heledron.minecraft.renderer3d.utilities.Matrix4
import com.heledron.minecraft.renderer3d.utilities.Vector4
import com.heledron.minecraft.renderer3d.renderer.PixelData
import com.heledron.minecraft.renderer3d.renderer.PixelShader
import com.heledron.minecraft.renderer3d.renderer.VertexData
import com.heledron.minecraft.renderer3d.renderer.VertexShader
import com.heledron.minecraft.renderer3d.utilities.Color

object RGBShader {
    var transform = Matrix4()

    var vertex: VertexShader = fun(vertex: DoubleArray): VertexData {
        if (vertex.size != 6) throw Error("RGBAVertex shader expects exactly 6 elements")
        val x = vertex[0];
        val y = vertex[1];
        val z = vertex[2];
        val r = vertex[3];
        val g = vertex[4];
        val b = vertex[5];

        val position = Vector4(x,y,z,1.0).apply { transformMat4(transform) };
        val pixel = doubleArrayOf(r, g, b)
        return VertexData(position, pixel)
    }

    var pixel: PixelShader = fun(pixel: DoubleArray): PixelData {
        val r = pixel[0];
        val g = pixel[1];
        val b = pixel[2];

        return PixelData(Color.fromFractions(r, g, b, 1.0))
    }
}