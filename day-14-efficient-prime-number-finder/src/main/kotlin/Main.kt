package org.example

fun Int.isPrime(): Boolean {
    if (this <= 1) {
        return false
    }

    for (i in 2 until this) {
        if (this % i == 0) {
            return false
        }
    }

    return true
}

//fun findFirstPrimeAfter(startNumber: Int): Int {
//    val numberSequence = generateSequence(startNumber) { it + 1 }
//    val primeNumbers = numberSequence.filter { it.isPrime() }
//
//   return primeNumbers.take(1).first()
//}

// Shorter way, I guess.
fun findFirstPrimeAfter(startNumber: Int): Int {
    return generateSequence(startNumber) { it + 1 }
        .find { it.isPrime() } ?: -1
}

fun main() {
    println("Searching for the first prime number greater than 1,000,000...")

    val startNumber = 1_000_000
    val firstPrime = findFirstPrimeAfter(startNumber)

    println("Found it: $firstPrime")
}