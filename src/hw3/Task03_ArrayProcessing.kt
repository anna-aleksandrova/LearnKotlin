package hw3

import kotlin.random.Random

fun main() {
    val numbers = Array(100) { Random.nextInt(-100, 101) }

    val processed = numbers
        .filter { it > 0 }
        .filter { it % 5 == 0 }
        .map { it * it }
        .sortedDescending()

    println("Max: ${processed.maxOrNull()}")
    println("Min: ${processed.minOrNull()}")

    val stringList = processed.map { it.toString() }
    val resultString = stringList.joinToString(" ")
    println(resultString)
}
