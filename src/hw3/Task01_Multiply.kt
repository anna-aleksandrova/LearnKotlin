package hw3

fun main() {
    val a = readln().trim().toInt()
    val b = readln().trim().toInt()

    var resultForEach = 0
    (1..b).forEach {
        resultForEach += a
    }
    println("forEach: $resultForEach")

    var resultRepeat = 0
    repeat(b) {
        resultRepeat += a
    }
    println("repeat: $resultRepeat")
}
