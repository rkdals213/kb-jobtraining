package com.example.kbjobtraining.domain

import com.example.kbjobtraining.config.NotionProperty
import com.example.kbjobtraining.dto.QueryDatabaseRequest
import com.example.kbjobtraining.dto.QueryDatabaseResponse
import com.example.kbjobtraining.infrastructure.NotionFeignClient
import org.springframework.stereotype.Component

@Component
class Notion(
    private val notionFeignClient: NotionFeignClient,
    private val notionProperty: NotionProperty,
) {
    fun findData(queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse {
        return notionFeignClient.findQuestions(notionProperty.databaseId, queryDatabaseRequest)
    }

}
