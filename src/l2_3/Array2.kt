fun main() {

//    val readOnlyShapes = listOf("triangle", "square", "circle")
//    println(readOnlyShapes)
//
    val mutableList = mutableListOf("triangle", "square", "circle")
//    mutableList[0] = "rect"
//    println(mutableList)
//
//    mutableList.add("hello")
//    println(mutableList)

    val mutableListMutabilityRestriction: List<String> = mutableList
    // mutableListMutabilityRestriction.add("hello23") немає операції додавання/зміни елементів
    val castReadOnlyListToMutable = mutableListMutabilityRestriction as MutableList<String>

    castReadOnlyListToMutable.add("hello23")
    println(mutableList)

    val readOnlyListToMutable = mutableList.toList()
    println(readOnlyListToMutable)

    val strings = readOnlyListToMutable as MutableList<String>
    strings.add("hello23")
    println(strings)
    println(mutableList)
}