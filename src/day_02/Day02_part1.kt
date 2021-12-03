package day_02

import readInput

fun main() {
    fun part1(input: List<String>) = input.groupBy({ it.contains("forward") }, {
        val line = it.split(" ")
        if (line.first().contains("up")) line.component2().toInt() * -1
        else line.component2().toInt()
    }).values.reduce { acc, list -> listOf(list.sum() * acc.sum()) }.first()

    val testInput = readInput("day_02/Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("day_02/Day02")
    println(part1(input))
}
