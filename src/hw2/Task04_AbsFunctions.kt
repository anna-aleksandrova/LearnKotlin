package hw2

import kotlin.math.sqrt

fun absValue(x: Int): Int = if (x < 0) -x else x

fun absValue(x: Double): Double = if (x < 0.0) -x else x

fun absValue(re: Double, im: Double): Double = sqrt(re * re + im * im)

fun main() {
    println(absValue(-42))
    println(absValue(-3.14))
    println(absValue(3.0, 4.0))
}
