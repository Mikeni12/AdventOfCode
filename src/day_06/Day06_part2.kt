package day_06

import readInput

fun main() {
    fun buildLanternFishMap() = buildMap<Int, Long> { (0..8).map { put(it, 0) } }.toMutableMap()

    fun part2(input: List<String>): Long {
        val timers = input.first().split(",").map { it.toInt() }.groupBy { it }
        val dictionary = buildLanternFishMap().apply {
            timers.entries.forEach { this[it.key] = it.value.size.toLong() }
        }

        repeat(256) {
            val dictionaryTemp = buildLanternFishMap()
            dictionary.entries.forEach {
                val key = it.key - 1
                if (key > -1) {
                    dictionaryTemp[key] = it.value + (dictionaryTemp[key] ?: 0)
                } else if (it.value > 0) {
                    dictionaryTemp[8] = it.value
                    dictionaryTemp[6] = it.value
                }
            }
            dictionary.putAll(dictionaryTemp)
        }
        return dictionary.values.sum()
    }

    val testInput = readInput("day_06/Input_test")
    check(part2(testInput) == 26984457539L)

    val input = readInput("day_06/Input")
    println(part2(input))
}
