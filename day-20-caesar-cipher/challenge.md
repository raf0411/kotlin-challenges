Day 20: The Caesar Cipher 🏛️

This challenge is purely about algorithmic logic, as you requested.

The Goal

You will implement the Caesar Cipher, one of the oldest and simplest forms of encryption. The cipher works by shifting each letter of a message a certain number of places down the alphabet. For example, with a shift of 3, 'A' becomes 'D', 'B' becomes 'E', and so on.

Breaking Down the Problem

    The Shift: Your cipher needs to handle a "shift factor" (e.g., 3).

    Wrapping: The shift must "wrap around" the alphabet. For example, with a shift of 3, 'X' becomes 'A', 'Y' becomes 'B', and 'Z' becomes 'C'.

    Case Sensitivity: You must preserve the original case of each letter. 'A' should shift to 'D', while 'a' shifts to 'd'.

    Non-Letters: Any characters that are not letters (spaces, numbers, punctuation) should be left unchanged.

Hint

The core of this problem is character arithmetic. You can convert a Char to its integer code using .code, perform math on it, and convert it back to a Char using .toChar(). To handle the wrap-around logic, the modulo operator (%) is your best friend. Remember to create separate logic for uppercase and lowercase letters, as they have different character code ranges.

Output

    Original:    The quick brown fox jumps over the lazy dog.
    Encrypted:   Wkh txlfn eurzq ira mxpsv ryhu wkh odcb grj.
    Decrypted:   The quick brown fox jumps over the lazy dog.
    ---
    Original:    Hello, World! 123
    Encrypted:   Mjqqt, Btwqi! 123