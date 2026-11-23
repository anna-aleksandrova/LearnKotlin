package hw2

fun main() {
    val year = readln().trim().toInt()
    val isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
    println(if (isLeap) "YES" else "NO")
}
