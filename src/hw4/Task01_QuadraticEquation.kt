package hw4

import kotlin.math.sqrt
import kotlin.random.Random

sealed interface Roots {
    data class TwoRoots(val x1: Double, val x2: Double) : Roots
    data class OneRoot(val x: Double) : Roots
    data object NoRealRoots : Roots
}

class QuadraticEquation(a: Double, var b: Double, var c: Double) {
    var a: Double = a
        set(value) {
            require(value != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
            field = value
        }

    init {
        require(a != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
    }

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    constructor(b: Double, c: Double) : this(1.0, b, c)

    val discriminant: Double
        get() = b * b - 4 * a * c

    fun solve(): List<Double> {
        val d = discriminant
        return when {
            d > 0 -> {
                val sqrtD = sqrt(d)
                listOf((-b - sqrtD) / (2 * a), (-b + sqrtD) / (2 * a))
            }
            d == 0.0 -> listOf(-b / (2 * a))
            else -> emptyList()
        }
    }

    fun solveSealed(): Roots {
        val d = discriminant
        return when {
            d > 0 -> {
                val sqrtD = sqrt(d)
                Roots.TwoRoots((-b - sqrtD) / (2 * a), (-b + sqrtD) / (2 * a))
            }
            d == 0.0 -> Roots.OneRoot(-b / (2 * a))
            else -> Roots.NoRealRoots
        }
    }

    override fun toString(): String = "${a}x^2 + (${b})x + (${c}) = 0"
}

fun main() {
    val eq = QuadraticEquation(1, -5, 6)
    println(eq)
    println("D = ${eq.discriminant}, roots =${eq.solve()}")

    eq.a = 2.0
    eq.b = -4.0
    eq.c = 2.0
    println(eq)
    println("D = ${eq.discriminant}, roots =${eq.solve()}")

    when (val roots = eq.solveSealed()) {
        is Roots.TwoRoots -> println("Two roots: ${roots.x1},${roots.x2}")
        is Roots.OneRoot -> println("One root: ${roots.x}")
        Roots.NoRealRoots -> println("No real roots")
    }

    val equations = List(100) {
        var a = Random.nextInt(-50, 51)
        while (a == 0) {
            a = Random.nextInt(-50, 51)
        }
        val b = Random.nextInt(-50, 51)
        val c = Random.nextInt(-50, 51)
        QuadraticEquation(a, b, c)
    }

    val twoRootsEquations = equations.filter { it.discriminant > 0 }
    twoRootsEquations.forEach {
        println("$it ->${it.solve()}")
    }
    println("Total with 2 roots: ${twoRootsEquations.size}")
}
