package org.example

data class Book (
    val title: String,
    val author: String,
    val year: Int,
    val rating: Double? = null
)

fun printBookReview(book: Book){
    // Original Code
//    book.let {
//        println("Title: ${it.title} by ${it.author}")
//        println("Review Score: ${it.rating ?: "N/A"}")
//    }

    // or

    val reviewScore = book.rating?.let { rating ->
        "${rating}/10.0"
    } ?: "N/A"

    println("Title: ${book.title} by ${book.author}")
    println("Review Score: $reviewScore")
}

fun main() {
    val bookWithReview = Book("1984", "George Orwell", 1949, 8.7)
    val bookWithoutReview = Book("Animal Farm", "George Orwell", 1945)

    println("--- Review 1 ---")
    printBookReview(bookWithReview)

    println("\n--- Review 2 ---")
    printBookReview(bookWithoutReview)
}