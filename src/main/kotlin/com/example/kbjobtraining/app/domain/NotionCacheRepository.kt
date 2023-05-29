package com.example.kbjobtraining.app.domain

import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.RefreshNotionCache
import com.example.kbjobtraining.app.dto.Subject
import com.example.kbjobtraining.app.infrastructure.NotionFeignClient
import com.example.kbjobtraining.config.NotionProperty
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class NotionCacheRepository(
    private val notionFeignClient: NotionFeignClient,
    private val notionProperty: NotionProperty,
    private val duration: Long = 1L
) {

    private val cache: MutableMap<Subject, NotionCache> = mutableMapOf()

    fun findData(subject: Subject, queryDatabaseRequest: QueryDatabaseRequest): NotionCache {
        return cache[subject] ?: registerCache(subject, queryDatabaseRequest)
    }

    @Async
    @EventListener
    fun refreshData(refreshNotionCache: RefreshNotionCache) {
        val (subject, queryDatabaseRequest) = refreshNotionCache

        registerCache(subject, queryDatabaseRequest)
    }

    private fun registerCache(subject: Subject, queryDatabaseRequest: QueryDatabaseRequest): NotionCache {
        val queryDatabaseResponse = notionFeignClient.findQuestions(notionProperty.databaseId, queryDatabaseRequest)
        val newNotionCache = NotionCache(LocalDateTime.now().plusMinutes(duration), queryDatabaseResponse)
        cache[subject] = newNotionCache

        return newNotionCache
    }
}