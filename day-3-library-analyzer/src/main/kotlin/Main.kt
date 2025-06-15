package org.example

data class Book (
    val title: String,
    val author: String,
    val year: Int
)

class Library(val books: List<Book>) {
    // Before Suggested Answer
//    fun findBooksPublishedAfter(year: Int): List<Book> {
//        val filteredBooks = books.filter { it.year > year }
//        return filteredBooks
//    }

//    fun groupBooksByAuthor(): Map<String, List<Book>> {
//        val groupedMap = books.groupBy { it.author }
//        return groupedMap
//    }

    // Suggested Answer
    fun findBooksPublishedAfter(year: Int): List<Book> = books.filter { it.year > year }
    fun groupBooksByAuthor(): Map<String, List<Book>> = books.groupBy { it.author }
}

fun main() {
    val books = listOf(
        Book("The Hobbit", "J.R.R. Tolkien", 1937),
        Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954),
        Book("1984", "George Orwell", 1949),
        Book("Animal Farm", "George Orwell", 1945),
        Book("The Silmarillion", "J.R.R. Tolkien", 1977)
    )

    val library = Library(books)

    println("Books published after 1950:")
    val recentBooks = library.findBooksPublishedAfter(1950)
    recentBooks.forEach { println("- ${it.title} (${it.year})") }

    println("\nBooks grouped by author:")
    val booksByAuthor = library.groupBooksByAuthor()
    booksByAuthor.forEach { (author, books) ->
        println("Author: $author")
        books.forEach { book ->
            println("  - ${book.title}")
        }
    }
}