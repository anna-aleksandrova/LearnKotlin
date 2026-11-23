package hw3

fun main() {
    val rawLogs = listOf(
        "2026-09-01 INFO: User logged in",
        "2026-09-01 ERROR: 500 Internal Server Error",
        "2026-09-01 WARN: High memory usage",
        "2026-09-01 ERROR: 404 Not Found",
        "2026-09-01 INFO: Payment processed"
    )

    var infoCount = 0
    var warnCount = 0
    var errorCount = 0
    val errorLogs = mutableListOf<String>()

    rawLogs.forEach { log ->
        when {
            log.contains("INFO") -> infoCount++
            log.contains("WARN") -> warnCount++
            log.contains("ERROR") -> {
                errorCount++
                errorLogs.add(log)
            }
        }
    }

    val report = """
        === Server Log Report ===
        Total logs: ${rawLogs.size}
        INFO:  $infoCount
        WARN:  $warnCount
        ERROR: $errorCount
        
        Error details:
        ${errorLogs.joinToString("\n")}
    """.trimIndent()

    println(report)
}
