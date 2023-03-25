package com.example.kbjobtraining

import org.slf4j.LoggerFactory

private val log = LoggerFactory.getLogger(Application::class.java)

fun <R> measureTime(functionName: String, f: () -> R): R {
    val start = System.currentTimeMillis()
    val result = f.invoke()
    val end = System.currentTimeMillis()
    log.info("$functionName | Elapsed time in milliseconds : ${end - start}ms")

    return result
}