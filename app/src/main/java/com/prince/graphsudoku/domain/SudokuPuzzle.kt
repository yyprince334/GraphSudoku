package com.prince.graphsudoku.domain

import com.prince.graphsudoku.computationlogic.buildNewSudoku
import java.io.Serializable
import java.util.*
import kotlin.collections.LinkedHashMap

data class SudokuPuzzle(
        /**
         * Note: What is the difference between HashMap vs HashSet?
         *
         * A HashMap stores key-value pairs
         * A HashSet stores only keys (assuming that's what you want to store)
         *  Therefore, we have a Map that stores <K, V>
         */
        val boundary: Int,
        val difficulty: Difficulty,
        val graph: LinkedHashMap<Int, LinkedList<SudokuNode>>
        = buildNewSudoku(boundary, difficulty).graph,
        var elapsedTime: Long = 0L
): Serializable {
        fun getValue(): LinkedHashMap<Int, LinkedList<SudokuNode>> = graph
}



