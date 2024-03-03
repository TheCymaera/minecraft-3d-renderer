package com.heledron.minecraft.renderer3d.renderer

import com.heledron.minecraft.renderer3d.utilities.Color
import com.heledron.minecraft.renderer3d.utilities.Vector4
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class VertexData(val position: Vector4, val pixel: DoubleArray)

class PixelData(var color: Color, var depth: Double = Double.NaN)

typealias VertexShader = (vertex: DoubleArray)-> VertexData

typealias PixelShader = (pixel: DoubleArray)-> PixelData

class RenderBuffer(width: Int, height: Int) {
    var width = max(1, width)
    var height = max(1, height)
    var data = Array(width * height) { PixelData(Color.fromRGBA(0,0,0,0)) }

    fun clear() {
        for (i in data.indices) data[i] = PixelData(Color.fromRGBA(0,0,0,0))
    }

    fun sample2D(u: Double, v: Double): PixelData {
        val uSafe = if (u > 1) 1.0 else if (u < 0) 0.0 else u
        val vSafe = if (v > 1) 1.0 else if (v < 0) 0.0 else v
        val uPixel = (uSafe * width).roundToInt()
        val vPixel = (vSafe * height).roundToInt()
        val index = max(0, min(vPixel * width + uPixel, data.size - 1))
        return data[index]
    }

    fun drawTriangles(vertices: Array<DoubleArray>, indices: IntArray, vertexShader: VertexShader, pixelShader: PixelShader, doDepthTesting: Boolean) {
        val vertexData = vertices.map(vertexShader)
        for (i in indices.indices step 3) {
            val v1 = vertexData[indices[i]]
            val v2 = vertexData[indices[i + 1]]
            val v3 = vertexData[indices[i + 2]]
            drawTriangle(v1, v2, v3, pixelShader, doDepthTesting)
        }
    }

    private fun drawTriangle(v1: VertexData, v2: VertexData, v3: VertexData, pixelShader: PixelShader, doDepthTesting: Boolean) {
        val pos1 = v1.position
        val pos2 = v2.position
        val pos3 = v3.position
        val pixel1 = v1.pixel
        val pixel2 = v2.pixel
        val pixel3 = v3.pixel
        val w1 = abs(1 / pos1.w)
        val w2 = abs(1 / pos2.w)
        val w3 = abs(1 / pos3.w)
        val x1 = pos1.x * w1
        val y1 = pos1.y * w1
        val z1 = pos1.z * w1
        val x2 = pos2.x * w2
        val y2 = pos2.y * w2
        val z2 = pos2.z * w2
        val x3 = pos3.x * w3
        val y3 = pos3.y * w3
        val z3 = pos3.z * w3

        // Pre-compute constants for finding barycentric coordinates
        val denom = 1 / ((y2 - y3) * (x1 - x3) + (x3 - x2) * (y1 - y3))
        val l1 = y2 - y3
        val l2 = y3 - y1
        val r1 = x3 - x2
        val r2 = x1 - x3

        // Get delta x & y (clip-space length of 1 "pixel")
        val dx = 2.0 / width
        val dy = 2.0 / height

        // iterate through every pixel
        var i = 0
        var y = -1.0
        var py = 0
        while (py < height) {
            var x = -1.0
            var px = 0
            while (px < width) {

                // find barycentric coordinates of point
                val b1 = (l1 * (x - x3) + r1 * (y - y3)) * denom
                val b2 = (l2 * (x - x3) + r2 * (y - y3)) * denom
                val b3 = 1 - b1 - b2

                // skip if point is not inside triangle
                if (b1 < 0 || b2 < 0 || b3 < 0) {
                    px++
                    x += dx
                    i++
                    continue
                }


                // find pixel z & w
                val pz = z1 * b1 + z2 * b2 + z3 * b3
                val pw = w1 * b1 + w2 * b2 + w3 * b3

                // depth testing
                val depth = 1 / pz
                if (doDepthTesting && data[i].depth > depth) {
                    px++
                    x += dx
                    i++
                    continue
                }

                // clip near & far
                if (pz < -1 || pz > 1) {
                    px++
                    x += dx
                    i++
                    continue
                }

                // find the perspective-corrected barycentric coordinates
                val cb1 = 1 / pw * b1 * w1
                val cb2 = 1 / pw * b2 * w2
                val cb3 = 1 / pw * b3 * w3

                // use perspective-corrected b-coordinates to find interpolated pixel
                val pixel = DoubleArray(pixel1.size)
                for (t in pixel.indices) {
                    pixel[t] = cb1 * pixel1[t] + cb2 * pixel2[t] + cb3 * pixel3[t]
                }

                // invoke pixel shader
                val pixelData = pixelShader(pixel)
                data[i] = pixelData
                if (pixelData.depth.isNaN()) pixelData.depth = depth
                px++
                x += dx
                i++
            }
            py++
            y += dy
        }
    }
}