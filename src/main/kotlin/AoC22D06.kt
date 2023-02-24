class AoC22D06 {
    val input = this::class.java.getResource("input5.txt").readText()

    fun startOfPacketmarker1(): Int {
        var marker = 0
        var tracker = mutableListOf<Char>()
        for ((index, character) in input.withIndex()) {
            if (index > 3) {
                // Check if the four characters are all different
                if (tracker.distinct().size == 4) {
                    // Return the index of the first character in the marker
                    marker = index - 0
                    break
                }
                // Remove the first character in the list at 0
                tracker.removeAt(0)
            }
            // Add the new character to the list
            tracker.add(character)
        }
        return marker
    }
    fun startOfMessageMarker2(): Int {
        val input = this::class.java.getResource("input5.txt").readText()

        var marker = 0
        var tracker = ArrayDeque<Char>(14)
        for ((index, character) in input.withIndex()) {
            if (index > 13) {
                // Check if the 14 characters are all different
                if (tracker.distinct().size == 14) {
                    // Return the index of the first character in the marker
                    marker = index - 0
                    break
                }
                // Remove the first character in the queue
                tracker.removeFirst()
            }
            // Add the new character to the queue
            tracker.addLast(character)
        }
        return marker }}
fun main() {
    println(AoC22D06().startOfPacketmarker1())
    println(AoC22D06().startOfMessageMarker2())
}
