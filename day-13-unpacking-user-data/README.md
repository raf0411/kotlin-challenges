Day 13: Unpacking User Data 🎁


The Goal

You need to create a function that fetches a user's summary data, which consists of their full name and their age. Your function must return both of these values at the same time. Then, in main, you must "unpack" these two values into two separate variables in a single line.



Expected Outcome

A single function that returns two distinct values (a String for the name and an Int for the age).

The code that calls this function must use a destructuring declaration to assign the results to two new variables, userName and userAge.



Hint

When a function needs to return multiple unrelated values, a simple way is to return an instance of the standard Pair<A, B> data class. The real magic happens on the calling side, where you can use a destructuring declaration like val (name, age) = yourFunction() to unpack the values from the Pair into separate variables.

