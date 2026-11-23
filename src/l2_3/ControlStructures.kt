fun main() {

    val x = readln().toInt()

    val absX: Int
    absX = if (x > 0) x else -x
    println("Модуль $x = $absX")
}