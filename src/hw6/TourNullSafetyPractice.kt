package hw6

data class TourEmployee(val name: String, var salary: Int)

fun employeeById(id: Int) = when (id) {
    1 -> TourEmployee("Mary", 20)
    2 -> null
    3 -> TourEmployee("John", 21)
    4 -> TourEmployee("Ann", 23)
    else -> null
}

fun salaryById(id: Int): Int = employeeById(id)?.salary ?: 0

data class NotifyUser(val name: String?)

fun getNotificationPreferences(user: Any, emailEnabled: Boolean, smsEnabled: Boolean): List<String> {
    val validUser = user as? NotifyUser ?: return emptyList()
    val userName = validUser.name ?: "Guest"
    return listOfNotNull(
        "Email Notifications enabled for $userName".takeIf { emailEnabled },
        "SMS Notifications enabled for $userName".takeIf { smsEnabled }
    )
}

data class Subscription(val name: String, val isActive: Boolean)

fun getActiveSubscription(subscriptions: List<Subscription>): Subscription? =
    subscriptions.singleOrNull { it.isActive }

data class SocialUser(val username: String, val isActive: Boolean)

fun getActiveUsernames(users: List<SocialUser>): List<String> =
    users.mapNotNull { user -> user.username.takeIf { user.isActive } }

fun validateStock(requested: Int?, available: Int?): Int {
    val validRequested = requested ?: return -1
    val validAvailable = available ?: return -1
    if (validRequested < 0) return -1
    if (validRequested > validAvailable) return -1
    return validRequested
}

fun main() {
    println((1..5).sumOf { id -> salaryById(id) })

    val user1 = NotifyUser("Alice")
    val user2 = NotifyUser(null)
    val invalidUser = "NotAUser"
    println(getNotificationPreferences(user1, emailEnabled = true, smsEnabled = false))
    println(getNotificationPreferences(user2, emailEnabled = false, smsEnabled = true))
    println(getNotificationPreferences(invalidUser, emailEnabled = true, smsEnabled = true))

    val userWithPremiumPlan = listOf(
        Subscription("Basic Plan", false),
        Subscription("Premium Plan", true)
    )
    val userWithConflictingPlans = listOf(
        Subscription("Basic Plan", true),
        Subscription("Premium Plan", true)
    )
    println(getActiveSubscription(userWithPremiumPlan))
    println(getActiveSubscription(userWithConflictingPlans))

    val allUsers = listOf(
        SocialUser("alice123", true),
        SocialUser("bob_the_builder", false),
        SocialUser("charlie99", true)
    )
    println(getActiveUsernames(allUsers))

    println(validateStock(5, 10))
    println(validateStock(null, 10))
    println(validateStock(-2, 10))
}
