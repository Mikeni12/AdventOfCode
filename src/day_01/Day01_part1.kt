package day_01

import readInput

fun main() {
    fun part1(input: List<String>) = input.zipWithNext { a, b -> b.toInt() - a.toInt() }.count { it > 0 }

    val testInput = readInput("day_01/Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("day_01/Day01")
    println(part1(input))
}
