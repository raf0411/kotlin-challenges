package org.example

class CaesarCipher(val shift: Int) {

    fun encrypt(message: String): String {
        var encryptedMessage = ""

        message.forEach {
            encryptedMessage += if (it.isLetter()) {
                if (it.isUpperCase()) {
                    ((it.code - 'A'.code + shift + 26) % 26 + 'A'.code).toChar()
                } else {
                    ((it.code - 'a'.code + shift + 26) % 26 + 'a'.code).toChar()
                }
            } else {
                it
            }
        }

        return encryptedMessage
    }

    // My Stupid Attempt Code
//    fun decrypt(message: String): String {
//        var decryptedMessage = ""
//
//        message.forEach {
//            decryptedMessage += if (it.isLetter()) {
//                if (it.isUpperCase()) {
//                    ((it.code - shift + 'A'.code) % 26 + 'A'.code).toChar()
//                } else {
//                    ((it.code - shift + 'a'.code) % 26 + 'a'.code).toChar()
//                }
//            } else {
//                it
//            }
//        }

    // Fixed
    fun decrypt(message: String): String {
        var decryptedMessage = ""

        message.forEach {
            decryptedMessage += if (it.isLetter()) {
                if (it.isUpperCase()) {
                    ((it.code - 'A'.code - shift + 26) % 26 + 'A'.code).toChar()
                } else {
                    ((it.code - 'a'.code - shift + 26) % 26 + 'a'.code).toChar()
                }
            } else {
                it
            }
        }

        return decryptedMessage
    }
}

// SUGGESTED CODE
//class CaesarCipher(private val shift: Int) {
//
//    fun encrypt(message: String): String {
//        return message.map { shiftChar(it, shift) }.joinToString("")
//    }
//
//    fun decrypt(message: String): String {
//        return message.map { shiftChar(it, -shift) }.joinToString("")
//    }
//
//    private fun shiftChar(c: Char, shift: Int): Char {
//        if (!c.isLetter()) {
//            return c
//        }
//        val base = if (c.isUpperCase()) 'A' else 'a'
//        val newCode = (c.code - base.code + shift + 26) % 26 + base.code
//        return newCode.toChar()
//    }
//}

fun main() {
    val cipher = CaesarCipher(shift = 3)

    val originalMessage = "The quick brown fox jumps over the lazy dog."
    println("Original:    $originalMessage")

    val encryptedMessage = cipher.encrypt(originalMessage)
    println("Encrypted:   $encryptedMessage")

    val decryptedMessage = cipher.decrypt(encryptedMessage)
    println("Decrypted:   $decryptedMessage")

    println("---")

    // Test with a different shift and punctuation
    val cipher2 = CaesarCipher(shift = 5)
    val message2 = "Hello, World! 123"
    println("Original:    $message2")
    println("Encrypted:   ${cipher2.encrypt(message2)}")
}

// 65 - 90 -> Huruf Kapital
// 97 - 122 -> Huruf Kecil

/*
    Original:    The quick brown fox jumps over the lazy dog.
    Encrypted:   Wkh txlfn eurzq ira mxpsv ryhu wkh odcb grj.
    Decrypted:   The quick brown fox jumps over the lazy dog.
    ---
    Original:    Hello, World! 123
    Encrypted:   Mjqqt, Btwqi! 123
*/