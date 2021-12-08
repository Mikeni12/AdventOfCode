package day_07

import readInput
import kotlin.math.absoluteValue

fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.first().split(",").map { it.toInt() }.sorted()
        val median = numbers[numbers.size / 2]
        return numbers.groupingBy { it }.eachCount().entries.fold(0) { counter, numberGroup ->
            counter + (numberGroup.key - median).absoluteValue * numberGroup.value
        }
    }

    val testInput = readInput("day_07/Input_test")
    check(part1(testInput) == 37)

    val input = readInput("day_07/Input")
    println(part1(input))
}
