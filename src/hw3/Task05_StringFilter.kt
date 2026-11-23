package hw3

fun stringFilter(strings: Collection<String>, predicate: (String) -> Boolean): List<String> {
    val result = mutableListOf<String>()
    strings.forEach {
        if (predicate(it)) {
            result.add(it)
        }
    }
    return result
}

fun stringFilter(strings: Array<String>, predicate: (String) -> Boolean): List<String> =
    stringFilter(strings.toList(), predicate)

fun main() {
    val words = listOf("kotlin", "java17", "android", "room2026", "compose", "v3")
    val filtered = stringFilter(words) { str -> str.any { it.isDigit() } }
    println(filtered)
}
