package hw6

data class Address(
    val street: String,
    val city: String?,
    val postalCode: String?
)

data class Client(
    val id: Int,
    val name: String,
    val email: String?,
    val address: Address?,
    val extraData: Any?
)

val clientList = listOf(
    Client(
        id = 1,
        name = "Олена",
        email = "olena@example.com",
        address = Address("вул. Саксаганського, 10", "Київ", "01033"),
        extraData = "VIP-клієнт"
    ),
    Client(
        id = 2,
        name = "Богдан",
        email = null,
        address = Address("вул. Городоцька, 45", "Львів", null),
        extraData = 42
    ),
    Client(
        id = 3,
        name = "Марія",
        email = "maria@example.com",
        address = null,
        extraData = null
    ),
    Client(
        id = 4,
        name = "Дмитро",
        email = null,
        address = Address("вул. Соборна, 1", null, null),
        extraData = "Очікує дзвінка"
    )
)

fun getShippingLabel(client: Client): String {
    val address = client.address ?: return "Самовивіз: Клієнт ${client.name} не надав адреси"
    val city = address.city ?: "Місто не вказано"
    val postalCode = address.postalCode ?: "Індекс невідомий"
    return "${address.street}, $city, $postalCode"
}

fun printClientNote(client: Client) {
    val note = client.extraData as? String ?: "Додаткові примітки відсутні"
    println("Клієнт ${client.name} -> Примітка: $note")
}

fun getClientEmailOrThrow(client: Client): String =
    client.email ?: throw IllegalArgumentException("Клієнт з ID ${client.id} не має електронної пошти!")

// Оператор !! припустимий лише під час дебагу або в тестах, коли потрібно миттєво впасти з NPE при порушенні гарантованого інваріанта.
fun forceGetPostalCode(client: Client): String = client.address!!.postalCode!!

fun main() {
    println("--- Завдання 1 ---")
    listOf(clientList[0], clientList[1], clientList[2]).forEach {
        println("Адреса ${it.name}: ${getShippingLabel(it)}")
    }

    println("\n--- Завдання 2 ---")
    clientList.forEach { printClientNote(it) }

    println("\n--- Завдання 3 ---")
    val rawEmails: List<String?> = clientList.map { it.email }
    val validEmails: List<String> = rawEmails.filterNotNull()
    val shortestEmailLength = validEmails.minByOrNull { it.length }?.length
    println("База email для розсилки: $validEmails")
    println("Довжина найкоротшого email: $shortestEmailLength")

    println("\n--- Завдання 4 ---")
    try {
        println(getClientEmailOrThrow(clientList[1]))
    } catch (e: IllegalArgumentException) {
        println("Перехоплено виняток: ${e.message}")
    }

    println("\n--- Завдання 5 ---")
    println("Індекс клієнта ${clientList[0].name}: ${forceGetPostalCode(clientList[0])}")
    try {
        println(forceGetPostalCode(clientList[1]))
    } catch (e: NullPointerException) {
        println("Перехоплено очікуваний NPE: ${e.message}")
    }
}
