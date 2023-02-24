class AoC21D01 {
    /*----------------------Före lösnin--------------------------------*/
    private val input = this::class.java.getResource("input2.txt").readText().split("\n")

    fun depthIncreasesPart1(): Int {
        var count = 0
        for (i in 0 until input.size - 1) {
            if (input[i].toInt() < input[i + 1].toInt()) {
                count++
            }
        }
        return count
    }

    fun depthIncreasesPart2(): Int {
         var count = 0
        for (i in 0 until input.size - 3) {
            var sum1 = 0
            var sum2 = 0
            for (j in 0 until input[i].length) {
                if (j < input[i].split(" ").size && j < input[i+3].split(" ").size) {
                    sum1 += input[i].split(" ")[j].toInt()
                    sum2 += input[i+3].split(" ")[j].toInt()
                }
            }
            if (sum2 > sum1) {
                count++
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(AoC21D01().depthIncreasesPart1())
    println(AoC21D01().depthIncreasesPart2())
}

