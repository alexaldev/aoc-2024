fun main() {

    val multRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
    val commandsRegex = Regex("""(do\(\)|don't\(\))""")

    fun sumOfLine(line: String): Int {
        return multRegex
            .findAll(line)
            .map { match ->
                match.groupValues[1].toInt() to match.groupValues[2].toInt()
            }
            .sumOf { it.first * it.second }
    }

    fun part1(input: List<String>): Int {

        return input.sumOf { sumOfLine(it) }
    }

    fun part2(input: List<String>): Int {


    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)

    val input = readInput("Day03")
    part1(input).println()

//    check(part2(testInput) == 31)
//    part2(input).println()
}
