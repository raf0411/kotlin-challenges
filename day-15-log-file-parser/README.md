Day 15: Log File Parser 📜

The Goal

You're writing a utility to analyze server logs. Each log entry is a single String with a specific format. Your task is to parse this string to extract structured data: the log level, the timestamp, and the message itself.

Expected Outcome

A data class to hold the parsed log information (e.g., LogEntry).

A function that takes a raw log string as input and returns an instance of your data class. If the string doesn't match the format, it should handle it gracefully (e.g., return null).

Hint

This is a perfect use case for Regular Expressions (Regex). A single Regex pattern can validate the format and extract all the required parts of the string in one step.

Look into Kotlin's Regex class. You’ll want to create a pattern with capturing groups (...) to grab the specific pieces of data. The .find() method on a Regex instance will give you a MatchResult, from which you can access the captured groups.

Expected Output

Entry 1: LogEntry(level=INFO, timestamp=2025-07-04T10:30:00, message=User 'admin' logged in successfully.)
Entry 2: LogEntry(level=ERROR, timestamp=2025-07-04T10:32:15, message=Failed to connect to database 'users_db'.)
Entry 3: null