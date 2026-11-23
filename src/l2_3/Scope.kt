fun main() {
    var i = 100
    println(i) // 100

    if (i == 100) {
        var i = 555
        println(i) // 555
    }

    println(i) // 100
}