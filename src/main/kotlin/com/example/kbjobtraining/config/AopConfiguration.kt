package com.example.kbjobtraining.config

import com.example.kbjobtraining.config.log.LogTrace
import com.example.kbjobtraining.config.log.LogTraceAspect
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AopConfiguration(
    private val logTrace: LogTrace,
) {

    @Bean
    fun logTraceAspect(): LogTraceAspect = LogTraceAspect(logTrace)
}