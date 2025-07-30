package org.example

class DatabaseConnection {
    init {
        println("(Initializing database connection...)")
    }

    fun fetchData() {
        println("(Fetching data from the database...)")
    }
}

class DataService {
    val databaseConnection: DatabaseConnection by lazy {
        DatabaseConnection()
    }
}

class Renderer {
    fun drawElements() {
        println("(Drawing UI elements...)")
    }
}

class MainScreen {
    private lateinit var renderer: Renderer

    fun onViewCreated() {
        println("(Renderer is being set up now...)")
        renderer = Renderer()
    }

    fun draw() {
        renderer.drawElements()
    }
}

fun main() {
    println("--- Scenario 1: Lazy Initialization ---")
    val service = DataService()
    println("DataService created. Database has not been touched.")
    println("First data fetch:")
    service.databaseConnection.fetchData()
    println("Second data fetch:")
    service.databaseConnection.fetchData()

    println("\n--- Scenario 2: Late Initialization ---")
    val screen = MainScreen()
    println("MainScreen created. Renderer is not yet available.")
    screen.onViewCreated()
    screen.draw()
}