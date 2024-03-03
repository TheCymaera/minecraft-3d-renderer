package com.heledron.minecraft.renderer3d.presentation

import org.bukkit.Material
import com.heledron.minecraft.renderer3d.renderer.RenderBuffer
import com.heledron.minecraft.renderer3d.utilities.Color
import org.bukkit.Location
import org.bukkit.util.Vector
import kotlin.math.abs

class Presentation(var location: Location, var strideX: Vector, var strideY: Vector) {
    fun draw(buffer: RenderBuffer) {
        for (x in 0 until buffer.width) {
            for (y in 0 until buffer.height) {
                val pixelLocation = location.clone()
                pixelLocation.add(strideX.clone().multiply(x))
                pixelLocation.add(strideY.clone().multiply(y))
                val blockType = convertColorToBlockType(buffer.data[x + y * buffer.width].color)
                pixelLocation.block.setType(blockType, false)
            }
        }
    }

    fun clear(buffer: RenderBuffer) {
        for (x in 0 until buffer.width) {
            for (y in 0 until buffer.height) {
                val pixelLocation = location.clone()
                pixelLocation.add(strideX.clone().multiply(x))
                pixelLocation.add(strideY.clone().multiply(y))
                pixelLocation.block.setType(Material.BARRIER, false)
            }
        }
    }

    private fun convertColorToBlockType(color: Color): Material {
        if (color.a == 0) return Material.BLACK_CONCRETE
        val id = "minecraft:" + findNearestMatch(color.r, color.g, color.b)
        val material = Material.matchMaterial(id)
        if (material == null) {
            println("UNKNOWN BLOCK: $id")
            return Material.BARRIER
        }
        return material
    }

    private fun findNearestMatch(r: Int, g: Int, b: Int): String {
        var bestColorDifference = Int.MAX_VALUE
        var bestColorBlock = ""
        for ((colorBlock, color) in colorMap) {
            val colorDifference = abs(r - color.r) + abs(g - color.g) + abs(b - color.b)
            if (colorDifference < bestColorDifference) {
                bestColorDifference = colorDifference
                bestColorBlock = colorBlock
            }
        }
        return bestColorBlock
    }
}