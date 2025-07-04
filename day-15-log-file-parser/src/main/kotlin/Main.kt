package org.example

data class LogEntry (
    val level: String?,
    val timestamp: String?,
    val message: String?
)


// Before Code
fun parseLogEntry(logEntry: String): LogEntry? {
    val regex = Regex("\\[(\\w+)] (\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}) - ([\\w\\W]+)")
    val match = regex.find(logEntry)

    if (match == null) {
        return null
    }

    val level = match.groups[1]?.value
    val timestamp = match.groups[2]?.value
    val message = match.groups[3]?.value // this should be (.*), it's a more common way

    val newLogEntry = LogEntry(level, timestamp, message)

    return newLogEntry
}


// Suggested Code
//fun parseLogEntry(logEntry: String): LogEntry? {
//    val regex = Regex("\\[(\\w+)] (\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}) - (.*)")
//    val match = regex.find(logEntry) ?: return null // Return null early if no match
//
//    // Destructure the result directly into named variables
//    val (level, timestamp, message) = match.destructured
//
//    return LogEntry(level, timestamp, message)
//}

fun main() {
    val logLine1 = "[INFO] 2025-07-04T10:30:00 - User 'admin' logged in successfully."
    val logLine2 = "[ERROR] 2025-07-04T10:32:15 - Failed to connect to database 'users_db'."
    val logLine3 = "This is not a valid log entry."

    val entry1 = parseLogEntry(logLine1)
    val entry2 = parseLogEntry(logLine2)
    val entry3 = parseLogEntry(logLine3)

    println("Entry 1: $entry1")
    println("Entry 2: $entry2")
    println("Entry 3: $entry3")
}

/*
    OUTPUT

    Entry 1: LogEntry(level=INFO, timestamp=2025-07-04T10:30:00, message=User 'admin' logged in successfully.)
    Entry 2: LogEntry(level=ERROR, timestamp=2025-07-04T10:32:15, message=Failed to connect to database 'users_db'.)
    Entry 3: null
*/