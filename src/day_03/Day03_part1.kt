package day_03

import readInput
import kotlin.math.pow

fun main() {
    fun part1(input: List<String>): Int {
        val ones = IntArray(input.first().length)
        val zeros = IntArray(input.first().length)
        input.forEach { line ->
            line.toCharArray().forEachIndexed { index, char ->
                if (char == '0') zeros[index]++ else ones[index]++
            }
        }

        var gamma = 0.0
        var epsilon = 0.0
        ones.forEachIndexed { index, one ->
            val decimal = 2.0.pow(ones.size - (index + 1))
            if (one > zeros[index]) gamma += decimal else epsilon += decimal
        }
        return (gamma * epsilon).toInt()
    }

    val testInput = readInput("day_03/Input_test")
    check(part1(testInput) == 198)

    val input = readInput("day_03/Input")
    println(part1(input))
}
