package day_05

import readInput

fun main() {
    fun isNotDiagonal(ranges: List<Int>) = ranges[0] == ranges[2] || ranges[1] == ranges[3]

    fun getRange(first: Int, second: Int) = if (first < second) first.rangeTo(second) else first.downTo(second)

    fun part1(input: List<String>): Int {
        val diagram = arrayListOf<Pair<Int, Int>>()
        input.forEach {
            val ranges = it.replace(" ", "")
                    .replace("->", ",")
                    .split(",")
                    .map { number -> number.toInt() }
            if (isNotDiagonal(ranges)) {
                val xRange = getRange(ranges[0], ranges[2])
                val yRange = getRange(ranges[1], ranges[3])
                for (x in xRange) {
                    for (y in yRange) {
                        diagram.add(Pair(x, y))
                    }
                }
            }
        }
        return diagram.groupBy { it }.filter { it.value.size > 1 }.size
    }

    val testInput = readInput("day_05/Input_test")
    check(part1(testInput) == 5)

    val input = readInput("day_05/Input")
    println(part1(input))
}
