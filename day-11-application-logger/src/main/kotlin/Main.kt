data class Log(
    val logLevel: LogLevel,
    val message: String
)

enum class LogLevel {
    INFO,
    WARNING,
    ERROR
}

object Logger {
    private val _logs = mutableListOf<Log>()
    val logs: List<Log> = _logs

    fun log(logLevel: LogLevel, message: String) {
        val newLog = Log(logLevel, message)
        _logs.add(newLog)
    }

    fun printHistory() {
//        for (log in logs) {
//            val logLevel = log.logLevel.name
//            val logMessage = log.message
//
//            println("[$logLevel]: $logMessage")
//        }

        // more functional way
        logs.forEach { log ->
            val logLevel = log.logLevel.name
            val logMessage = log.message
            println("[$logLevel]: $logMessage")
        }
    }

}

fun main() {
    println("Logging application events...")

    Logger.log(LogLevel.INFO, "Application starting up.")

    performSomeTask()

    Logger.log(LogLevel.ERROR, "Failed to fetch user data.")

    println("\n--- Log History ---")
    Logger.printHistory()
}

fun performSomeTask() {
    Logger.log(LogLevel.INFO, "Performing a critical task.")
    Logger.log(LogLevel.WARNING, "Network connection is slow.")
}
