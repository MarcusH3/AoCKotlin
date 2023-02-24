import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AoC22D10Test {

    @Test
    fun getNum() {
        val input = listOf("noop", "add 10")
        assertEquals(12460, AoC22D10().getNum())
    }
}