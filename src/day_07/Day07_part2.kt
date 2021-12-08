package day_07

import readInput
import kotlin.math.absoluteValue

fun main() {
    fun part2(input: List<String>): Int {
        val numbers = input.first().split(",").map { it.toInt() }
        val min = numbers.minOf { it }
        val max = numbers.maxOf { it }
        return (min..max).minOf { position ->
            numbers.groupingBy { it }.eachCount().entries.fold(0) { counter, numberGroup ->
                val operation = (numberGroup.key - position).absoluteValue
                counter + operation * numberGroup.value * (operation + 1) / 2
            }
        }
    }

    val testInput = readInput("day_07/Input_test")
    check(part2(testInput) == 168)

    val input = readInput("day_07/Input")
    println(part2(input))
}
