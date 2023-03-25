package com.example.kbjobtraining.config

import com.example.kbjobtraining.domain.NotionAspect
import com.example.kbjobtraining.domain.NotionCacheRepository
import com.example.kbjobtraining.presentation.FindQuestionControllerAspect
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AopConfig(
    private val notionCacheRepository: NotionCacheRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Bean
    fun notionAspect(): NotionAspect = NotionAspect(notionCacheRepository, applicationEventPublisher)

    @Bean
    fun findQuestionControllerAspect(): FindQuestionControllerAspect = FindQuestionControllerAspect()
}