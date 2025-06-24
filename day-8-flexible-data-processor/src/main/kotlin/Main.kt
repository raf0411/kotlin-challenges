package org.example

fun processNumbers(list: List<Int>, operation: (Int) -> Int ): List<Int> =
    list.map { operation(it) }

fun main() {
    val sensorReadings = listOf(1, 2, 3, 4, 5, 10)

    val doubledReadings = processNumbers(sensorReadings) { reading ->
        reading * 2
    }

    println("Doubled Readings: $doubledReadings")


    val squaredReadings = processNumbers(sensorReadings) { reading ->
        reading * reading
    }
    println("Squared Readings: $squaredReadings")


    val remainderReadings = processNumbers(sensorReadings) { reading ->
        reading % 3
    }
    println("Remainder (when divided by 3): $remainderReadings")
}