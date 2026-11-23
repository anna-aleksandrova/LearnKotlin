package hw2

fun main() {
    val a = readln().trim().toInt()
    val b = readln().trim().toInt()
    var result = 0
    for (i in 1..b) {
        result += a
    }
    println(result)
}
