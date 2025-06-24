package org.example

fun processNumbers(list: List<Int>, operation: (Int) -> Int ): List<Int> =
    list.map { operation(it) }

fun main() {
    val sensorReadings = listOf(1, 2, 3, 4, 5, 10)

    val doubledReadings = processNumbers(sensorReadings) { reading ->
        reading * 2
    }
    val squaredReadings = processNumbers(sensorReadings) { reading ->
        reading * reading
    }
    val remainderReadings = processNumbers(sensorReadings) { reading ->
        reading % 3
    }

    println("Doubled Readings: $doubledReadings")
    println("Squared Readings: $squaredReadings")
    println("Remainder (when divided by 3): $remainderReadings")
}