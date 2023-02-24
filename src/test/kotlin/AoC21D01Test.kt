import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AoC21D01Test {

    @Test
    fun testDepthIncreasesPart1() {
        val aoc21D01 = AoC21D01()
        assertEquals(1681, aoc21D01.depthIncreasesPart1())
    }

    @Test
    fun testDepthIncreasesPart2() {
        val aoc21D01 = AoC21D01()
        assertEquals(1704, aoc21D01.depthIncreasesPart2())
    }
}