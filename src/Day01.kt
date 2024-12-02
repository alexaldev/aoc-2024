import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {

        val lists = input
            .map { it.split("   ") }

        val first = lists
            .map { it.first().toInt() }
            .sorted()

        val second = lists
            .map { it[1].toInt() }
            .sorted()

        return first
            .zip(second)
            .sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {

        val lists = input
            .map { it.split("   ") }

        val first = lists
            .map { it.first().toInt() }

        val second = lists
            .map { it[1].toInt() }

        return first
            .map { it to second.count { secondI -> secondI == it } }
            .sumOf { it.first * it.second }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    val input = readInput("Day01")
    part1(input).println()

//    check(part2(testInput) == 31)
//    part2(input).println()
}
