fun main() {
    val integers = listOf(12, 5, 12, -13, -2, 16)

    integers
        .filter {it > 0}
        .map{ it * it }
        .forEach {println(it)}
}