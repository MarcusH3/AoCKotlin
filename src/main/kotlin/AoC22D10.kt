import kotlin.math.absoluteValue

class AoC22D10 {
    val input = this::class.java.getResource("input4.txt").readText().split("\n")

    sealed class Command {
        object Noop : Command()
        data class AddX(val value: Int) : Command()
    }

    fun parseInput(input: () -> List<String>) = input().map { it.toCommand() }

    private fun String.toCommand(): Command {
        val split = this.split(" ")
        return when {
            split.component1() == "noop" -> Command.Noop
            else -> Command.AddX(split.component2().toInt())
        }
    }

    fun getNum(): Int {
        fun Int.signalStrength(registerValue: Int) = this * registerValue

        fun List<Int>.sum(cycle: Int, registerValue: Int) = this.contains(cycle).run {
            when (this) {
                true -> cycle.signalStrength(registerValue)
                false -> 0
            }
        }

        val input = parseInput { input }

        var cycle = 0
        var registerValue = 1

        var cycles = 0
        val toRegister = listOf(20, 60, 100, 140, 180, 220)

        input.forEach { command ->
            when (command) {
                is Command.AddX -> {
                    repeat(2) { time ->
                        cycle++
                        cycles += toRegister.sum(cycle = cycle, registerValue = registerValue)
                        if (time == 1) registerValue += command.value
                    }
                }

                Command.Noop -> {
                    cycle++
                    cycles += toRegister.sum(cycle = cycle, registerValue = registerValue)
                }
            }
        }

        return cycles
    }}
fun main(args: Array<String>) {
    println(AoC22D10().getNum())}




