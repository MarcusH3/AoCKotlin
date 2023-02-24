class AoC22D06E {
    private val input = this::class.java.getResource("input5.txt").readText()

    fun startOfPacketmarker1(): Int {
        val window = mutableListOf<Char>()
        for ((index, char) in input.withIndex()) {
            window.add(char)
            if (window.size == 4) {
                if (window.distinct().size == 4) {
                    return index + 1
                }
                window.removeAt(0)
            }
        }
        return -1
    }
    fun startOfMessageMarker2(): Int {
        val window = mutableListOf<Char>()
        for ((index, char) in input.withIndex()) {
            window.add(char)
            if (window.size == 14) {
                if (window.distinct().size == 14) {
                    return index + 1
                }
                window.removeAt(0)
            }
        }
        return -1
    }
}
    fun main() {
        println(AoC22D06E().startOfPacketmarker1())
        println(AoC22D06E().startOfMessageMarker2())
    }
//https://github.com/tginsberg/advent-2022-kotlin/blob/main/src/main/kotlin/com/ginsberg/advent2022/Day06.kt

