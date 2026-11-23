package hw2

fun main() {
    val input = readln().trim()
    val isNegative = input.startsWith("-")
    val digits = if (isNegative) input.substring(1) else input
    val reversed = digits.reversed().toLong()
    println(if (isNegative && reversed != 0L) -reversed else reversed)
}
