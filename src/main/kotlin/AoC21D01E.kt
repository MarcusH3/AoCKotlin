class AoC21D01E {
    val input = this::class.java.getResource("input2.txt").readText().split("\n")

    fun depthIncreasesFuncPart1(): Int {
        var i = 0
        if (input[0] < input[1]) i++
        return input.zipWithNext().count(){it.first <it.second} + i
    }

    fun depthIncreasesFuncPart2(): Int =
        input.windowed(3, 1)
            .map { it.map { it.toInt() } }
            .zipWithNext()
            .count { compareValues(it.first.sum(), it.second.sum()) < 0
            }
}

    fun main(args: Array<String>) {
        println(AoC21D01E().depthIncreasesFuncPart1())
        println(AoC21D01E().depthIncreasesFuncPart2())
    }

//Efter lösning.
//https://github.com/catcutecat/AdventOfCode2021/blob/main/src/Day01.kt