package com.prince.graphsudoku.domain

import java.io.Serializable


data class SudokuNode(
        val x: Int,
        val y: Int,
        var color: Int = 0,
        var readOnly: Boolean = true
): Serializable {
    /**
     * The x value is *100 to allow for uniqueness
     */
    override fun hashCode(): Int {
        return getHash(x, y)
    }
}

internal fun getHash(x: Int, y: Int):Int {
    val newX = x*100
    return "$newX$y".toInt()
}