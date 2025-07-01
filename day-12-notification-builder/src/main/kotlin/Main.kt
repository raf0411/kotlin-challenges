package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class Notification(
    var title: String,
    var message: String,
    var icon: String? = null,
    var priority: String? = null,
    var timestamp: Long? = null
) {
    fun addTimestamp() {
        this.timestamp = System.currentTimeMillis()
    }
}

object NotificationSender {
    const val DEFAULT_VALUE_ICON = "default_icon.png"
    const val DEFAULT_VALUE_PRIORITY = "NORMAL"
    const val DEFAULT_VALUE_TIMESTAMP = "Not set"

    fun send(notification: Notification) {
        runBlocking {
            println(">> Sending Notification...")
            delay(5000L)
            println(" - Title: ${notification.title}")
            println(" - Text: ${notification.message}")
            println(" - Icon: ${notification.icon?.plus(".png") ?: DEFAULT_VALUE_ICON}")
            println(" - Priority: ${notification.priority ?: DEFAULT_VALUE_PRIORITY}")
            println(" - Timestamp: ${notification.timestamp ?: DEFAULT_VALUE_TIMESTAMP}")
        }
    }
}

fun main() {
    val simpleNotification = Notification("New Message", "Hey, how are you?")
    NotificationSender.send(simpleNotification)

    println("--------------------")

    val importantNotification = Notification("System Alert", "Your storage is almost full.").apply {
        icon = "ic_storage_alert"
        priority = "HIGH"

        addTimestamp()
    }

    NotificationSender.send(importantNotification)
}