data class Product(val name: String, val price: Double)
data class Box<T> (val item: T)

// My Solution
//inline fun <reified T> printBoxContent(box: Box<T>) {
//    when (T::class.simpleName) {
//        "Int" -> { println("This box contains an Integer with value: ${box.item}") }
//        else -> { println("This box contains a ${T::class.simpleName} with value: ${box.item}") }
//    }
//}

// No 'inline' or 'reified' needed for this approach
// AI Solution
fun <T> printBoxContent(box: Box<T>) {
    val item = box.item
    when (item) {
        is Int -> println("This box contains an Integer with value: $item")
        is String -> println("This box contains a String with value: $item")
        is Product -> println("This box contains a Product with value: $item")
        else -> println("This box contains an unknown type with value: $item")
    }
}

fun main() {
    val stringBox = Box("Hello, Generics!")
    val intBox = Box(123)
    val productBox = Box(Product("Laptop", 1200.0))

    printBoxContent(stringBox)
    printBoxContent(intBox)
    printBoxContent(productBox)
}