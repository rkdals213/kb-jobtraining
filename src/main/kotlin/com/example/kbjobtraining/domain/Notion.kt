package com.example.kbjobtraining.domain

import com.example.kbjobtraining.infrastructure.NotionFeignClient
import com.example.kbjobtraining.dto.QueryDatabaseRequest
import com.example.kbjobtraining.dto.QueryDatabaseResponse
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
class Notion(
    private val notionFeignClient: NotionFeignClient,
    private val notionProperty: NotionProperty
) {
    fun findData(queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse {
        return notionFeignClient.findQuestions(notionProperty.databaseId, queryDatabaseRequest)
    }
}

@ConfigurationProperties(prefix = "notion")
data class NotionProperty(
    var databaseId: String,
    var notionVersion: String,
    var bearerToken: String
)