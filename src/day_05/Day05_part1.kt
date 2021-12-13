package day_05

import readInput

fun main() {
    fun isHorizontal(ranges: List<Int>) = ranges[1] == ranges[3]

    fun isVertical(ranges: List<Int>) = ranges[0] == ranges[2]

    fun getRange(first: Int, second: Int) = if (first < second) first..second else second..first

    fun part1(input: List<String>): Int {
        val diagram = arrayListOf<Pair<Int, Int>>()
        input.forEach {
            val ranges = it.replace(" ", "")
                    .replace("->", ",")
                    .split(",")
                    .map { number -> number.toInt() }
            when {
                isHorizontal(ranges) -> {
                    val y = ranges[1]
                    for (x in getRange(ranges[0], ranges[2])) {
                        diagram.add(Pair(x, y))
                    }
                }
                isVertical(ranges) -> {
                    val x = ranges[0]
                    for (y in getRange(ranges[1], ranges[3])) {
                        diagram.add(Pair(x, y))
                    }
                }
            }
        }
        return diagram.groupBy { Pair(it.first, it.second) }.filter { it.value.size > 1 }.size
    }

    val testInput = readInput("day_05/Input_test")
    check(part1(testInput) == 5)

    val input = readInput("day_05/Input")
    println(part1(input))
}
