package org.example

fun String.reversed(): String{
    return StringBuilder(this).reversed().toString()
}

fun main() {
    println("Reversing the word 'Bedroom' : ${"Bedroom".reversed()}")
    println("Reversing the word 'Proposition' : ${"Proposition".reversed()}")
    println("Reversing the word 'Rotator' : ${"Rotator".reversed()}") // Palindrome
    println("Reversing the word 'Kayak' : ${"Kayak".reversed()}") // Palindrome
}