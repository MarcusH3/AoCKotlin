class AoC22D07 {
    var size = 0L
    var winner = 70000000L

    val input = this::class.java.getResource("input3.txt").readText().split("\n")

    fun sumDirectories1(): Long {

        val root = Node("root", null)
        root.nodes["/"] = Node("/", root)
        buildNodeTreeFromCommandList(input, root)

        return getSmallNodesSum(root)
    }

    fun findAndDelete2(): Long {
        val root = Node("root", null)
        root.nodes["/"] = Node("/", root)
        buildNodeTreeFromCommandList(input, root)

        val MAX_HD = 70000000
        val UPDATE_SIZE = 30000000

        val rootSize = getNodeSize(root)
        size  = MAX_HD - rootSize
        size  = UPDATE_SIZE - size
        smallestDeletableDir(root)
        return winner
    }

    private fun smallestDeletableDir(node: Node) {
        if (getNodeSize(node) in (size  + 1) until winner) {
            winner = getNodeSize(node)
        }
        node.nodes.values.forEach {
            smallestDeletableDir(it)
        }
    }

    private fun getSmallNodesSum(node: Node): Long {
        var sum = 0L

        node.nodes.values.forEach {
            if (getNodeSize(it) <= 100000) {
                sum += getNodeSize(it)
            }
            sum += getSmallNodesSum(it)
        }

        return sum
    }

    private fun getNodeSize(node: Node): Long {
        var size = 0L
        node.items.forEach {
            size += it.size
        }
        node.nodes.values.forEach {
            size += getNodeSize(it)
        }
        return size
    }

    private tailrec fun buildNodeTreeFromCommandList(input: List<String>, workingDirectory: Node?) {
        if (input.isEmpty()) {
            return
        }
        val line = input.first()
        val rest = input.drop(1)
        val parts = line.split(" ")

        when (parts[0]) {
            "dir" -> {
                workingDirectory?.nodes?.set(parts[1], Node(parts[1], workingDirectory))
                buildNodeTreeFromCommandList(rest, workingDirectory)
            }
            "$" -> {
                if (parts[1] == "cd") {
                    if (parts[2] == "..") {
                        buildNodeTreeFromCommandList(rest, workingDirectory?.parent)
                    } else {
                        val node = workingDirectory?.nodes?.get(parts[2])
                        buildNodeTreeFromCommandList(rest, node)
                    }
                } else if (parts[1] == "ls") {
                    buildNodeTreeFromCommandList(rest, workingDirectory)
                }
            }
            else -> {
                val item = Item(parts[0].toLong())
                workingDirectory?.items?.add(item)
                buildNodeTreeFromCommandList(rest, workingDirectory)
            }
        }
    }
}

data class Node(val name: String, val parent: Node?) {
    val nodes = mutableMapOf<String, Node>()
    val items = mutableListOf<Item>()
}

data class Item(val size: Long)

fun main() {
    println(AoC22D07().sumDirectories1())
    println(AoC22D07().findAndDelete2())
}