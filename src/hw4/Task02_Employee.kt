package hw4

class Employee(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    var bonus: Int = 0

    operator fun component1(): String = firstName
    operator fun component2(): String = lastName
    operator fun component3(): String = position

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        position: String = this.position
    ): Employee = Employee(firstName, lastName, position)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Employee) return false
        return firstName == other.firstName &&
            lastName == other.lastName &&
            position == other.position
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }

    override fun toString(): String =
        "Employee(firstName=$firstName, lastName=$lastName, position=$position)"
}

fun main() {
    val emp1 = Employee("John", "Doe", "Junior Developer")
    val emp2 = Employee("John", "Doe", "Junior Developer")
    val emp3 = emp1

    println(emp1)
    println("emp1 === emp2: ${emp1 === emp2}")
    println("emp1 === emp3: ${emp1 === emp3}")
    println("emp1 == emp2: ${emp1 == emp2}")

    val (name, surname, pos) = emp1
    println("$name | $surname \vert{}$pos")

    val promoted = emp1.copy(position = "Senior Developer")
    println(promoted)

    emp1.bonus = 500
    emp2.bonus = 1000
    println("emp1 == emp2 with different bonus: ${emp1 == emp2}")
}
