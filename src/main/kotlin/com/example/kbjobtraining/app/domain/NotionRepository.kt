package com.example.kbjobtraining.app.domain

import com.example.kbjobtraining.config.NotionProperty
import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.QueryDatabaseResponse
import com.example.kbjobtraining.app.infrastructure.NotionFeignClient
import org.springframework.stereotype.Repository

@Repository
class NotionRepository(
    private val notionFeignClient: NotionFeignClient,
    private val notionProperty: NotionProperty,
) {
    fun findData(queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse {
        return notionFeignClient.findQuestions(notionProperty.databaseId, queryDatabaseRequest)
    }

}
