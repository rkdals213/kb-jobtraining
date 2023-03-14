package com.example.kbjobtraining.config

import com.example.kbjobtraining.domain.NotionAspect
import com.example.kbjobtraining.domain.NotionCacheRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AopConfig(
    private val notionCacheRepository: NotionCacheRepository
) {

    @Bean
    fun notionAspect(): NotionAspect = NotionAspect(notionCacheRepository)
}