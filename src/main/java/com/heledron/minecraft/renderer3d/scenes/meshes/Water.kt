package com.heledron.minecraft.renderer3d.scenes.meshes

object Water {
	val vertices = arrayOf(
		doubleArrayOf(-6.0, -5.0, -6.0, 1.0, 1.0),
		doubleArrayOf(-6.0, -5.0, +6.0, 1.0, 0.0),
		doubleArrayOf(+6.0, -5.0, +6.0, 0.0, 0.0),
		doubleArrayOf(+6.0, -5.0, -6.0, 0.0, 1.0)
	)
	val indices = intArrayOf(
		0, 1, 2,
		0, 2, 3
	)
}