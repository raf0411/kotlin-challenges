package org.example

data class Product(
    val name: String,
    val price: Double,
    val discount: Discount? = null
)

sealed class Discount {
    data class Percentage(val value: Double): Discount()
    data class Flat(val value: Double): Discount()
}

fun applyDiscount(product: Product, discount: Discount): Double {
    return if (discount is Discount.Percentage) {
        val totalDiscountPrice = product.price - (discount.value / 100) * product.price

        if (totalDiscountPrice < 0) {
           0.0
        } else {
            totalDiscountPrice
        }

    } else if (discount is Discount.Flat) {
        val totalDiscountPrice = product.price - discount.value

        if (totalDiscountPrice < 0) {
            0.0
        } else {
            totalDiscountPrice
        }

    } else {
        0.0
    }
}

//fun applyDiscount(product: Product, discount: Discount): Double {
//    val totalDiscountPrice = when (discount) {
//        is Discount.Flat -> product.price * (1 - discount.value / 100)
//        is Discount.Percentage -> product.price - discount.value
//    }
//
//    // The coerceAtLeast function is a clean way to handle the "never less than 0" rule.
//    return totalDiscountPrice.coerceAtLeast(0.0)
//}

fun main() {
    val programmingBook = Product("Learning Kotlin", 50.00)
    val coffeeMug = Product("Code & Coffee", 15.00)

    val tenPercentDiscount = Discount.Percentage(10.0)
    val sevenDollarDiscount = Discount.Flat(7.00)
    val bigDiscount = Discount.Flat(20.00)

    val bookPrice = applyDiscount(programmingBook, tenPercentDiscount)
    println("'${programmingBook.name}' with a 10% discount: $$bookPrice")

    val mugPrice1 = applyDiscount(coffeeMug, sevenDollarDiscount)
    println("'${coffeeMug.name}' with a $7 discount: $$mugPrice1")

    val mugPrice2 = applyDiscount(coffeeMug, bigDiscount)
    println("'${coffeeMug.name}' with a $20 discount: $$mugPrice2")
}
