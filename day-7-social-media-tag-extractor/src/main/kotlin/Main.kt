package org.example

data class Post(val id: Int, val content: String, val tags: List<String>)

//fun extractUniqueTags(post: List<Post>): List<String> {
//    val tags: List<String> = post.flatMap { it.tags }.distinct()
//    return tags
//}

// shorter
fun extractUniqueTags(post: List<Post>): List<String> = 
    post.flatMap { it.tags }.distinct()

fun main() {
    val posts = listOf(
        Post(1, "Kotlin is awesome!", listOf("kotlin", "android", "development")),
        Post(2, "Learning about Sealed Classes.", listOf("kotlin", "oop")),
        Post(3, "Jetpack Compose basics.", listOf("android", "ui", "jetpack")),
        Post(4, "Why use flatMap?", listOf("kotlin", "functional"))
    )

    val uniqueTags = extractUniqueTags(posts)
    println("All unique tags used: $uniqueTags")
    // The order doesn't matter, but the content does.
    // Expected: [kotlin, android, development, oop, ui, jetpack, functional]
}