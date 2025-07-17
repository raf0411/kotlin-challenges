package org.example

data class Product(
    val name: String,
    val price: Double,
    var quantity: Int,
)

class Inventory {
    private val _inventory: MutableMap<String, Product> = mutableMapOf()
    val inventory: Map<String, Product> = _inventory

    fun addProduct(name: String, price: Double, quantity: Int): Boolean {
        return if (_inventory.containsKey(name)) {
            _inventory.getValue(name).quantity += quantity
            true
        } else {
            _inventory.put(name, Product(name, price, quantity))
            false
        }
    }

    // Suggested Code
    fun addProductAI(name: String, price: Double, quantity: Int) {
        val existingProduct = _inventory[name]
        if (existingProduct != null) {
            // Product exists, just update quantity
            existingProduct.quantity += quantity
        } else {
            // It's a new product, add it to the map
            _inventory[name] = Product(name, price, quantity)
        }
    }

    fun sellProduct(name: String, quantity: Int): Boolean {
        return if (_inventory.containsKey(name)) {
            val productStock = _inventory.getValue(name).quantity

            if (productStock < quantity) {
                false
            } else {
                _inventory.getValue(name).quantity -= quantity
                true
            }
        } else {
            false
        }
    }

    // Suggested Code
    fun sellProductAI(name: String, quantity: Int): Boolean {
        val product = _inventory[name] ?: return false // Return early if product doesn't exist

        if (product.quantity >= quantity) {
            product.quantity -= quantity
            return true
        }

        return false // Not enough stock
    }

    fun getTotalValue(): Double =
        _inventory.values.sumOf {
            it.price * it.quantity
        }
}

fun main() {
    val inventory = Inventory()

    inventory.addProduct("Laptop", 1200.0, 10)
    inventory.addProduct("Mouse", 25.0, 30)
    println("Initial inventory value: $${inventory.getTotalValue()}")

    val sale1Success = inventory.sellProduct("Mouse", 5)
    println("Sold 5 mice. Sale successful: $sale1Success. New inventory value: $${inventory.getTotalValue()}")

    val sale2Success = inventory.sellProduct("Laptop", 15)
    println("Tried to sell 15 laptops. Sale successful: $sale2Success. Inventory value should be unchanged: $${inventory.getTotalValue()}")

    inventory.addProduct("Laptop", 1200.0, 5)
    println("Added 5 more laptops. New inventory value: $${inventory.getTotalValue()}")

    val sale3Success = inventory.sellProduct("Keyboard", 1)
    println("Tried to sell 1 keyboard. Sale successful: $sale3Success. Inventory value should be unchanged: $${inventory.getTotalValue()}")
}

/*
    Initial inventory value: $12750.0
    Sold 5 mice. Sale successful: true. New inventory value: $12625.0
    Tried to sell 15 laptops. Sale successful: false. Inventory value should be unchanged: $12625.0
    Added 5 more laptops. New inventory value: $18625.0
    Tried to sell 1 keyboard. Sale successful: false. Inventory value should be unchanged: $18625.0
*/