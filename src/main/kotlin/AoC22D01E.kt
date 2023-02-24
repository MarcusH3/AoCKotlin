class AoC22D01E {

    fun calCountFunc(): List<Int> {
            val input = this::class.java.getResource("input.txt").readText().trim().split("\n\n")
            return input.map { line ->  line.split("\n").filter { it != "" }.sumOf { it.toInt() }
            }.sortedDescending().take(3)
        }
    }
    fun main(args: Array<String>) {
        println(AoC22D01E().calCountFunc() +AoC22D01E().calCountFunc().sum() )}


// Efter lösning inspirerad av:
// https://github.com/exosyphon/advent_code_2022/blob/main/day_1/src/main/kotlin/Day1.kt
