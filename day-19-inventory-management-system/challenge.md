Day 19: Inventory Management System 🏬

As requested, this challenge is designed to make you practice your logic and problem-solving by breaking a larger problem into smaller pieces.

The Goal

You're building a simple inventory management system. The system must track different products, their prices, and their stock levels. You need to implement the core logic for adding new stock, selling products (while checking stock levels), and calculating the total value of all products in the inventory.

Breaking Down the Problem

To solve this, think about it in these smaller pieces:

Representing Data: How will you represent a single product, including its name, price, and the quantity you have in stock?

Storing the Inventory: How will you store the entire collection of these products? A Map is a good choice because it lets you look up products quickly by name.

Adding Stock: What should happen if you add a product that's already in the inventory? Should you update the existing product's stock or replace it?

Selling Stock: This is the core logic. Before you "sell" a product, you must check if you have enough stock. What should your function do or return if there isn't enough?

Calculating Value: How do you iterate through all your products to calculate the total value (sum of price * quantity for every product)?

Hint

A good way to store the inventory is a MutableMap<String, Product>, where the String key is the product's unique name. This allows you to quickly look up a product to update its stock. For the sellProduct logic, you must check if there is enough stock before you decrease the quantity. Consider what your function should return (perhaps a Boolean) to indicate whether the sale was successful.

Output

Initial inventory value: $12750.0
Sold 5 mice. Sale successful: true. New inventory value: $12625.0
Tried to sell 15 laptops. Sale successful: false. Inventory value should be unchanged: $12625.0
Added 5 more laptops. New inventory value: $18625.0
Tried to sell 1 keyboard. Sale successful: false. Inventory value should be unchanged: $18625.0