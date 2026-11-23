package hw3

fun countByPredicate(strings: Collection<String>, predicate: (String) -> Boolean): Int {
    var count = 0
    strings.forEach {
        if (predicate(it)) {
            count++
        }
    }
    return count
}

fun countByPredicate(strings: Array<String>, predicate: (String) -> Boolean): Int =
    countByPredicate(strings.toList(), predicate)

fun main() {
    val words = listOf("kotlin", "java17", "android", "room2026", "compose", "v3")
    val withDigits = countByPredicate(words) { str -> str.any { it.isDigit() } }
    println("Strings with digits: $withDigits")
}
