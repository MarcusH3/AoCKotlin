import kotlin.math.absoluteValue

class AoC22D10E {
    val input = this::class.java.getResource("input4.txt").readText().split("\n")
    private val signals: List<Int> = parseInput(input).runningReduce(Int::plus)

    fun solvePart1(): Int = signals.sampleSignals().sum()

    private fun List<Int>.sampleSignals(): List<Int> =
        (60 .. size step 40).map {cycle ->
            cycle * this[cycle - 1]
        } + this[19] * 20


    private fun parseInput(input: List<String>): List<Int> =
        buildList {
            add(1)
            input.forEach { line ->
                add(0)
                if (line.startsWith("addx")) { add(line.substringAfter(" ").toInt())
                }
            }
        }}
    fun main() {
        println(AoC22D10E().solvePart1())
    }

//* Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2022/day10/
