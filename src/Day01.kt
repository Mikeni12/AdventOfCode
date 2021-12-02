fun main() {
    fun part1(input: List<String>) = input.zipWithNext { a, b -> b.toInt() - a.toInt() }.count { it > 0 }

    fun part2(input: List<String>) = input.windowed(3, 1) { window -> window.sumOf { it.toInt() } }
        .zipWithNext { a, b -> b - a }
        .count { it > 0 }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
