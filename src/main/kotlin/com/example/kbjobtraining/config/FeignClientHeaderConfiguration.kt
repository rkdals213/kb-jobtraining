package com.example.kbjobtraining.config

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientHeaderConfiguration(
    private val notionProperty: NotionProperty,
) {
    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header("Authorization", notionProperty.bearerToken)
            requestTemplate.header("Notion-Version", notionProperty.notionVersion)
        }
    }
}