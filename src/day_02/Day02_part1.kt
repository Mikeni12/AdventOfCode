package day_02

import readInput

fun main() {
    fun part1(input: List<String>) = input
        .groupBy({ it.contains("forward") }) {
            val line = it.split(" ")
            if (line.first().contains("up")) line.component2().toInt() * -1
            else line.component2().toInt()
        }
        .mapValues { it.value.sum() }.values
        .reduce { acc, sum -> acc * sum }

    val testInput = readInput("day_02/Input_test")
    check(part1(testInput) == 150)

    val input = readInput("day_02/Input")
    println(part1(input))
}
