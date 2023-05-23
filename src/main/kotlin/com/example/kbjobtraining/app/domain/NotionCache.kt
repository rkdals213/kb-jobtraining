package com.example.kbjobtraining.app.domain

import com.example.kbjobtraining.app.dto.QueryDatabaseResponse
import java.time.LocalDateTime

data class NotionCache(
    val expiration: LocalDateTime,
    val content: QueryDatabaseResponse,
) {
    fun expired(): Boolean = LocalDateTime.now() > expiration
}