package com.example.kbjobtraining.config

import com.example.kbjobtraining.app.domain.NotionAspect
import com.example.kbjobtraining.app.domain.NotionCacheRepository
import com.example.kbjobtraining.config.log.LogTrace
import com.example.kbjobtraining.config.log.LogTraceAspect
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AopConfiguration(
    private val notionCacheRepository: NotionCacheRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val logTrace: LogTrace,
) {

    @Bean
    fun notionAspect(): NotionAspect = NotionAspect(notionCacheRepository, applicationEventPublisher)

    @Bean
    fun logTraceAspect(): LogTraceAspect = LogTraceAspect(logTrace)
}