Day 18: Server Status Report 📊

The Goal

You're creating a monitoring dashboard and need to generate a formatted status report for a server. You have a data class that holds all the server's metrics, and you need to write a function that takes this object and builds a clean, multi-line string report from its properties.

Expected Outcome

    A ServerStatus data class to hold various metrics.

    A function generateStatusReport(status: ServerStatus): String that uses a scope function to cleanly build the report string. This function should access multiple properties of the status object without repeatedly typing status..

Hint

To perform multiple operations on a single object without repeating its name, the scope functions with(object) { ... } or object.run { ... } are excellent choices. They provide the object as the context (this) inside their lambda block, making your code much cleaner when you need to access many of the object's properties and methods.

Expected Output

--- Server Status Report ---
Server: Primary Web Server
CPU Usage: 75.5%
Memory: 2048 MB
Connections: 152
--- End of Report ---