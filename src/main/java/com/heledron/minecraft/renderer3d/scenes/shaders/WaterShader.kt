package com.heledron.minecraft.renderer3d.scenes.shaders

import com.heledron.minecraft.renderer3d.utilities.Matrix4
import com.heledron.minecraft.renderer3d.utilities.Vector4
import com.heledron.minecraft.renderer3d.renderer.*
import com.heledron.minecraft.renderer3d.utilities.Color
import kotlin.math.sin

object WaterShader {
    var emptyReflectionTexture = RenderBuffer(1, 1)

    var transform = Matrix4()
    var reflectionTexture = emptyReflectionTexture
    var distortionFrame = 0.0
    var distortionMagnitude = 0.03
    var distortionRate = 2.0
    var distortionPeriods = 100.0
    var baseColor = Color.fromFractions(0.3, 0.5, 0.7, 1.0)
    var reflectionOpacity = .7

    val vertex: VertexShader = fun (vertex): VertexData {
        if (vertex.size != 5) throw java.lang.Error("WaterVertex shader expects exactly 5 elements")
        val x: Double = vertex[0]
        val y: Double = vertex[1]
        val z: Double = vertex[2]
        val u: Double = vertex[3]
        val v: Double = vertex[4]

        val position = Vector4(x,y,z,1.0).apply { transformMat4(transform) }
        val pixel = doubleArrayOf(u, v)
        return VertexData(position, pixel)
    }

    val pixel: PixelShader = fun (pixel): PixelData {
        val u: Double = pixel[0]
        val v: Double = pixel[1]

        // wave distortion effect
        val distortion = distortionMagnitude *
                sin(distortionRate * distortionFrame) *
                sin(v * distortionPeriods)

        // sample from reflection texture
        val reflection = reflectionTexture.sample2D(u + distortion, v).color

        // add tint to sample
        val fragColor = if (reflection.a == 0) baseColor else Color.fromRGBA(
                (baseColor.r * (1 - reflectionOpacity) + reflection.r * reflectionOpacity).toInt(),
                (baseColor.g * (1 - reflectionOpacity) + reflection.g * reflectionOpacity).toInt(),
                (baseColor.b * (1 - reflectionOpacity) + reflection.b * reflectionOpacity).toInt(),
        )
        return PixelData(fragColor)
    }
}