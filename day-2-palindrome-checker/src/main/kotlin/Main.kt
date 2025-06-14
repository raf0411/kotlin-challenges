package org.example

data class Book (
    val title: String,
    val author: String,
    val year: Int
)

fun isTitlePalindrome(book: Book): Boolean {
    val pattern = Regex("[.,:;?!'()/{}*_@\\s\\-\\[\\]\"]+")
    val clearedTitled = pattern.replace(book.title, "")
    val reversedTitle = clearedTitled.reversed()

    return reversedTitle.equals(clearedTitled, ignoreCase = true)
}

fun main() {
    val book1 = Book(title="A Man, A Plan, A Canal: Panama", author="Leigh Mercer", year=1948)
    println("Book 1 Title: '${book1.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book1)}\n")

    val book2 = Book(title="The Lord of the Rings", author="J.R.R. Tolkien", year=1954)
    println("Book 2 Title: '${book2.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book2)}\n")

    val book3 = Book(title="RaceCaR", author="Anonymous", year=2025)
    println("Book 3 Title: '${book3.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book3)}\n")

    val book4 = Book(title="Eva, can I see bees in a cave?", author="Unknown", year=2000)
    println("Book 4 Title: '${book4.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book4)}\n")

    val book5 = Book(title="This is not a palindrome", author="Test Author", year=2023)
    println("Book 5 Title: '${book5.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book5)}\n")

    val book6 = Book(title="Rotator", author="Test Author", year=2023)
    println("Book 6 Title: '${book6.title}'")
    println("Is it a palindrome? -> ${isTitlePalindrome(book6)}\n")
}