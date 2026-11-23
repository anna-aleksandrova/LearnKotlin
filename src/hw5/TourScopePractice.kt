package hw5

data class ProductInfo(var priceInDollars: Double?)

class ProductService {
    fun getPriceInEuros(product: ProductInfo): Double? =
        product.priceInDollars?.let { convertToEuros(it) }

    private fun convertToEuros(dollars: Double): Double = dollars * 0.85
}

data class User(val id: Int, var email: String)

fun updateEmail(user: User, newEmail: String): User = user.apply {
    email = newEmail
}.also {
    println("Updating email for user with ID: ${it.id}")
}

fun main() {
    val service = ProductService()
    val product = ProductInfo(100.0)
    println("Price in Euros: ${service.getPriceInEuros(product)}")

    val user = User(1, "old_email@example.com")
    val updatedUser = updateEmail(user, "new_email@example.com")
    println("Updated User: $updatedUser")
}
