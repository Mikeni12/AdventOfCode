package day_02

import readInput

fun main() {
    fun part2(input: List<String>): Int = input.fold(Triple(0, 0, 0)) { acc, line ->
        val value = line.split(" ").component2().toInt()
        when {
            line.contains("up") -> Triple(acc.first, acc.second, acc.third - value)
            line.contains("down") -> Triple(acc.first, acc.second, acc.third + value)
            else -> Triple(acc.first + value, acc.second + acc.third * value, acc.third)
        }
    }.run { first * second }

    val testInput = readInput("day_02/Input_test")
    check(part2(testInput) == 900)

    val input = readInput("day_02/Input")
    println(part2(input))
}
