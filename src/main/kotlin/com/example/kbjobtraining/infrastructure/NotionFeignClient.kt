package com.example.kbjobtraining.infrastructure

import com.example.kbjobtraining.config.NotionProperty
import com.example.kbjobtraining.dto.QueryDatabaseRequest
import com.example.kbjobtraining.dto.QueryDatabaseResponse
import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@FeignClient(value = "example", url = "https://api.notion.com", configuration = [HeaderConfiguration::class])
interface NotionFeignClient {

    @PostMapping("/v1/databases/{id}/query")
    fun findQuestions(@PathVariable id: String, @RequestBody queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse

}

@Configuration
class HeaderConfiguration(
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