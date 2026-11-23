//fun maxOf(a: Int, b: Int): Int {
//    return if (a > b) a else b
//}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun sum(a: Int, b: Int) = a + b

fun foo(x: Int, y: Int, func: (Int, Int) -> Int) {
    println(func(x, y))
}

fun main() {

//    val maxof = {a: Int, b: Int -> if (a > b) a else b }
//
//    val maxOf: (Int, Int) -> Int = {a: Int, b: Int ->
//        val x = 12
//        print(x)
//        print("Hello")
//        if (a > b) a else b
//    }
    foo(12, 2, ::sum)
    foo(12, 2, func = {x, y -> x + y})
    foo(12, 2) {x, y -> x + y}

    println(maxOf(1, 2))
}