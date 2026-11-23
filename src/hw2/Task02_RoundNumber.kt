package hw2

fun main() {
    val number = readln().toDouble()
    val n = readln().toInt()
    println(String.format("%.${n}f", number))
}
