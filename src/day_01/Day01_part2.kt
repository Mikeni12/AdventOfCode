package day_01

import readInput

fun main() {
    fun part2(input: List<String>) = input.windowed(3, 1) { window -> window.sumOf { it.toInt() } }
        .zipWithNext { a, b -> b - a }
        .count { it > 0 }

    val testInput = readInput("day_01/Day01_test")
    check(part2(testInput) == 5)

    val input = readInput("day_01/Day01")
    println(part2(input))
}
