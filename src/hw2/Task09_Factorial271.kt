package hw2

import java.math.BigInteger

fun main() {
    val n = readln().trim().toInt()
    var fact = BigInteger.ONE
    for (i in 2..n) {
        fact = fact.multiply(BigInteger.valueOf(i.toLong()))
    }
    println(fact)
}
