package day_06

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val numbers = input.first().split(",").map { it.toInt() }.toMutableList()
        repeat(80) {
            repeat(numbers.size) { index ->
                if (numbers[index] == 0) {
                    numbers[index] = 7
                    numbers.add(8)
                }
                numbers[index] -= 1
            }
        }
        return numbers.size
    }

    val testInput = readInput("day_06/Input_test")
    check(part1(testInput) == 5934)

    val input = readInput("day_06/Input")
    println(part1(input))
}
