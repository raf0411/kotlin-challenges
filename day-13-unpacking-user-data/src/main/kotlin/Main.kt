package org.example

fun fetchUserSummary(): Pair<String, Int> = Pair("Alex", 28)

fun main() {
    val (userName, userAge) = fetchUserSummary()

    println("User: $userName")
    println("Age: $userAge")
    println("---")
    println("In 5 years, $userName will be ${userAge + 5} years old.")
}

/*
    Expected Output
    Plaintext

    User: Alex
    Age: 28
    ---
    In 5 years, Alex will be 33 years old.
*/