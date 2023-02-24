import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AoC22D06Test {

    @Test
    fun startOfPacketmarker1() {
        assertEquals(1142, AoC22D06().startOfPacketmarker1())

    }
    @Test
    fun startOfMessageMarker2() {
        assertEquals(2803, AoC22D06().startOfMessageMarker2())

    }
}