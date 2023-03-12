package com.example.back.domain

import com.example.back.infrastructure.NotionFeignClient
import com.example.back.dto.QueryDatabaseRequest
import com.example.back.dto.QueryDatabaseResponse
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