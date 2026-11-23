package hw3

fun main() {
    val input = readln()
    val frequencies = mutableMapOf<Char, Int>()

    input.forEach { ch ->
        frequencies[ch] = frequencies.getOrDefault(ch, 0) + 1
    }

    frequencies.forEach { (ch, count) ->
        println("'$ch': $count")
    }
}
