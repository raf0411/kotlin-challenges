package org.example

import java.io.File

data class User (
    val id: Int,
    val name: String?,
    val email: String?,
    val city: String?
)

fun findUsersInCity(filePath: String, city: String): List<User> =
    File(filePath).useLines { lines ->
        lines.drop(1).mapNotNull { line ->
            val parts = line.split(',')
            if (parts.size >= 4) {
                User(
                    id = parts[0].toInt(), // more safe to use toIntOrNull()
                    name = parts[1],
                    email = parts[2],
                    city = parts[3]
                )
            } else {
                null
            }
        }
        .filter { it.city == city }
        .toList()
    }

// Suggested Code
fun findUsersInCitySecondary(filePath: String, city: String): List<User> =
    File(filePath).useLines { lines ->
        lines.drop(1).mapNotNull { line ->
            val parts = line.split(',')
            if (parts.size < 4) return@mapNotNull null

            val id = parts[0].toIntOrNull() ?: return@mapNotNull null 

            User(
                id = id,
                name = parts[1].takeIf { it.isNotEmpty() },
                email = parts[2].takeIf { it.isNotEmpty() },
                city = parts[3]
            )
        }
            .filter { it.city == city }
            .toList()
    }

fun main() {
    val filePath = "users.csv"
    val newYorkUsers = findUsersInCity(filePath, "New York")

    println("Users from New York:")
    newYorkUsers.forEach(::println)
}
