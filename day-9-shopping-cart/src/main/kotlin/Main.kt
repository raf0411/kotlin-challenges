package org.example

data class Item (
    val name: String,
    val price: Double
)

// Code Before Revision
//class ShoppingCart {
//    private val shoppingCart = mutableListOf<Item>()
//    var totalPrice: Double = 0.0
//    val _shoppingCart: MutableList<Item> = shoppingCart
//
//    fun addItem(item: Item) {
//        _shoppingCart.add(item)
//        totalPrice = _shoppingCart.sumOf { it.price }
//    }
//}

// Revisioned Code
class ShoppingCart {
    private val _shoppingCart = mutableListOf<Item>()
    val totalPrice: Double
        get() = _shoppingCart.sumOf { it.price }
    // This prevents from modifying the list publicly, READ ONLY MODE
    val shoppingCart: List<Item> = _shoppingCart

    fun addItem(item: Item) {
        _shoppingCart.add(item)
    }
}

fun main() {
    val cart = ShoppingCart()
    println("Initial cart total: $${cart.totalPrice}") // A new cart should be empty.


    cart.addItem(Item("Milk", 3.50))
    cart.addItem(Item("Bread", 2.25))

    println("Total after adding milk and bread: $${cart.totalPrice}")

    cart.addItem(Item("Coffee", 8.99))

    println("Final total: $${cart.totalPrice}")
}