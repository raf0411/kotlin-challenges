package org.example

class InvalidUserDataException(message: String): Exception(message) {

}

data class User(
    val id: Int,
    val email: String
)

fun createUser(id: Int, email: String): User {
    if (id < 0) {
        throw InvalidUserDataException("User ID cannot be negative.")
    } else if (!email.contains("@")) {
        throw InvalidUserDataException("Email is not valid.")
    }

    return User(id, email)
}

// Using require()
fun createUserWithRequire(id: Int, email: String): User {
    // Throws IllegalArgumentException if id < 0
    require(id >= 0) { "User ID cannot be negative." }

    // Throws IllegalArgumentException if email doesn't contain "@"
    require(email.contains("@")) { "Email is not valid." }

    return User(id, email)
}

fun main() {
    // Day 5: User Validation
    try {
        val user1 = createUser(101, "contact@android.com")
        println("User created successfully: $user1")
    } catch (e: InvalidUserDataException) {
        println("Error: ${e.message}")
    }

    try {
        val user2 = createUser(-1, "bad@user.com")
        println("User created successfully: $user2")
    } catch (e: InvalidUserDataException) {
        println("Error: ${e.message}")
    }

    try {
        val user3 = createUser(102, "no-at-symbol.com")
        println("User created successfully: $user3")
    } catch (e: InvalidUserDataException) {
        println("Error: ${e.message}")
    }
}