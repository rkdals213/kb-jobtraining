package com.example.kbjobtraining.config.log

interface LogTrace {
    fun begin(message: String): TraceStatus
    fun end(status: TraceStatus)
    fun exception(status: TraceStatus, errorMessage: String)
}