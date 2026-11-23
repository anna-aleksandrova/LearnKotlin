fun main() {

    val fruits = listOf("apple", "banana", "orange")

    for (fruit in fruits) {
        println(fruit)
    }

    fruits.forEach(::println)
}