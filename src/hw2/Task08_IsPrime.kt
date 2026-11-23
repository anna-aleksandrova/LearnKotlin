package hw2

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    var i = 2
    while (i * i <= n) {
        if (n % i == 0) return false
        i++
    }
    return true
}

fun main() {
    val n = readln().trim().toInt()
    println(if (isPrime(n)) "Prime" else "Not prime")
}
