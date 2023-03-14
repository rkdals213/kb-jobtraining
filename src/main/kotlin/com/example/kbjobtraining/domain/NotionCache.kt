package com.example.kbjobtraining.domain

import com.example.kbjobtraining.dto.QueryDatabaseResponse
import java.time.LocalDateTime

data class NotionCache(
    val expiration: LocalDateTime,
    val content: QueryDatabaseResponse,
) {
    fun expired(): Boolean = LocalDateTime.now() > expiration
}