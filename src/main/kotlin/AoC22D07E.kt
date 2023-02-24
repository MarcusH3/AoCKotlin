class AoC22D07E {
    val input = this::class.java.getResource("input3.txt").readText().split("\n")
    val rootDirectory: Directory = parseInput(input)

        fun sumDirectories1(): Int = rootDirectory.find { it.size <= 100_000 }.sumOf { it.size }

        fun findAndDelete2(): Int {
            val unusedSpace = 70_000_000 - rootDirectory.size
            val deficit = 30_000_000 - unusedSpace
            return rootDirectory.find { it.size >= deficit }.minBy { it.size }.size
        }

        private fun parseInput(input: List<String>): Directory {
            val callStack = ArrayDeque<Directory>().apply { add(Directory("/")) }
            input.forEach { item ->
                when {
                    item == "$ ls" -> {}
                    item.startsWith("dir") -> {}
                    item == "$ cd /" -> callStack.removeIf { it.name != "/" }
                    item == "$ cd .." -> callStack.removeFirst()
                    item.startsWith("$ cd") -> {
                        val name = item.substringAfterLast(" ")
                        callStack.addFirst(callStack.first().traverse(name))
                    }

                    else -> {
                        val size = item.substringBefore(" ").toInt()
                        callStack.first().addFile(size)
                    }
                }
            }
            return callStack.last()
        }
    class Directory(val name: String) {
        private val subDirs: MutableMap<String, Directory> = mutableMapOf()
        private var sizeOfFiles: Int = 0

        val size: Int
            get() = sizeOfFiles + subDirs.values.sumOf { it.size }

        fun addFile(size: Int) {
            sizeOfFiles += size
        }

        fun traverse(dir: String): Directory =
            subDirs.getOrPut(dir) { Directory(dir) }

        fun find(predicate: (Directory) -> Boolean): List<Directory> =
            subDirs.values.filter(predicate) +
                    subDirs.values.flatMap { it.find(predicate) }
    }
        }
    fun main() {
        println(AoC22D07E().sumDirectories1())
        println(AoC22D07E().findAndDelete2())}

//https://github.com/PoisonedYouth/advent-of-code-kotlin-2022/blob/main/src/day07/Day07.kt