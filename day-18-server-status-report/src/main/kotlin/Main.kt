package org.example

data class ServerStatus (
    val name: String,
    val cpuUsage: Double,
    val memoryUsedMb: Int,
    val activeConnections: Int
)

fun generateStatusReport(status: ServerStatus): String =
    status.run {
            "--- Server Status Report ---\n" +
            "Server: $name\n" +
            "CPU Usage: $cpuUsage%\n" +
            "Memory: $memoryUsedMb MB\n" +
            "Connections: $activeConnections\n" +
            "--- End of Report ---"
    }

// Suggested Code
//fun generateStatusReport(status: ServerStatus): String =
//    status.run {
//        """
//        --- Server Status Report ---
//        Server: $name
//        CPU Usage: $cpuUsage%
//        Memory: $memoryUsedMb MB
//        Connections: $activeConnections
//        --- End of Report ---
//        """.trimIndent()
//    }

fun main() {
    val currentStatus = ServerStatus(
        name = "Primary Web Server",
        cpuUsage = 75.5,
        memoryUsedMb = 2048,
        activeConnections = 152
    )

    val report = generateStatusReport(currentStatus)
    println(report)
}

/*
    OUTPUT :

    --- Server Status Report ---
    Server: Primary Web Server
    CPU Usage: 75.5%
    Memory: 2048 MB
    Connections: 152
    --- End of Report ---

*/