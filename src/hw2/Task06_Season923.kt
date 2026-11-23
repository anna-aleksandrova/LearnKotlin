package hw2

fun main() {
    val m = readln().trim().toInt()
    val season = when (m) {
        in 3..5 -> "Spring"
        in 6..8 -> "Summer"
        in 9..11 -> "Autumn"
        12, 1, 2 -> "Winter"
        else -> "Invalid month"
    }
    println(season)
}
