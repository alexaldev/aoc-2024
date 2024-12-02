import kotlin.math.abs

fun main() {

    fun allAscendingAndInRange(nums: List<Int>): Boolean {
        return nums
            .zipWithNext { a, b -> (b > a) && (abs(b - a) in (1..3)) }
            .count { it } == nums.size - 1
    }

    fun allDescendingAndInRange(nums: List<Int>): Boolean {
        return nums
            .zipWithNext { a, b -> (b < a) && (abs(b - a) in (1..3)) }
            .count { it } == nums.size - 1
    }

    fun partialLists(nums: List<Int>): List<List<Int>> {
        return List(nums.size) { index ->
            nums.filterIndexed { i, _ -> i != index }
        }
    }

    fun allOrSublistAscendingAndInRange(nums: List<Int>): Boolean {

        // First try list as is
        val allAscending = allAscendingAndInRange(nums)

        if (allAscending) return true

        // Then try any sublist
        return partialLists(nums).any { allAscendingAndInRange(it) }
    }

    fun allOrSublistDescendingAndInRange(nums: List<Int>): Boolean {

        // First try list as is
        val allAscending = allDescendingAndInRange(nums)

        if (allAscending) return true

        // Then try any sublist
        return partialLists(nums).any { allDescendingAndInRange(it) }
    }

    fun part1(input: List<String>): Int {

        return input
            .map { s -> s.split(" ").map { it.toInt() } }
            .count { allAscendingAndInRange(it) or allDescendingAndInRange(it) }
    }

    fun part2(input: List<String>): Int {

        return  input
            .map { s -> s.split(" ").map { it.toInt() } }
            .count { allOrSublistAscendingAndInRange(it) or allOrSublistDescendingAndInRange(it) }
    }

    val testInput = readInput("Day02_test")
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part2(input).println()
}
