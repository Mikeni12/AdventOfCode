package day_05

import readInput

fun main() {
    fun isNotDiagonal(ranges: List<Int>) = ranges[0] == ranges[2] || ranges[1] == ranges[3]

    fun getRange(first: Int, second: Int) = if (first < second) first.rangeTo(second) else first.downTo(second)

    fun part2(input: List<String>): Int {
        val diagram = arrayListOf<Pair<Int, Int>>()
        input.forEach {
            val ranges = it.replace(" ", "")
                    .replace("->", ",")
                    .split(",")
                    .map { number -> number.toInt() }
            val xRange = getRange(ranges[0], ranges[2])
            val yRange = getRange(ranges[1], ranges[3])
            if (isNotDiagonal(ranges)) {
                for (x in xRange) {
                    for (y in yRange) {
                        diagram.add(Pair(x, y))
                    }
                }
            } else {
                xRange.forEachIndexed { index, x ->
                    diagram.add(Pair(x, yRange.elementAt(index)))
                }
            }
        }
        return diagram.groupBy { it }.filter { it.value.size > 1 }.size
    }

    val testInput = readInput("day_05/Input_test")
    check(part2(testInput) == 12)

    val input = readInput("day_05/Input")
    println(part2(input))
}
