fun main() {
    // за номером місяця визначити пору року

    val monthNumber = readln().toInt()

    val season =
        when (monthNumber) {
            in 3..5 -> {"весна"}
            in 6..8 -> {"літо"}
            in 9..11 -> {"осінь"}
            in 1..2, 12 -> {"зима"}
            else -> {"Неправильний номер місяця"}
        }
    println("Month: $monthNumber is $season")

//    val season =
//        if (monthNumber in 3..5) {
//            "весна"
//        } else if (monthNumber in 6..8) {
//            "літо"
//        } else if (monthNumber in 9..11) {
//            "осінь"
//        } else if (monthNumber in 1..2 || monthNumber == 12) {
//            "зима"
//        } else {
//            "Неправильний номер місяця"
//        }
//
//    println("Month: $monthNumber is $season")
}