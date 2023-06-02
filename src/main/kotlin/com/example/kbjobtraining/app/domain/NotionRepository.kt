package com.example.kbjobtraining.app.domain

import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.QueryDatabaseResponse
import com.example.kbjobtraining.app.dto.RefreshNotionCache
import com.example.kbjobtraining.app.dto.Subject
import com.example.kbjobtraining.app.infrastructure.NotionFeignClient
import com.example.kbjobtraining.config.NotionProperty
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class NotionRepository(
    private val notionFeignClient: NotionFeignClient,
    private val notionProperty: NotionProperty,
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val duration: Long = 1L,
) {

    private val cache: MutableMap<Subject, NotionCache> = mutableMapOf()

    fun findData(queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse {
        val subject = Subject.findByContent(queryDatabaseRequest.subject())
        val notionCache = cache[subject] ?: registerCache(subject, queryDatabaseRequest)

        if (notionCache.expired()) {
            applicationEventPublisher.publishEvent(RefreshNotionCache(subject, queryDatabaseRequest))
        }

        return notionCache.content
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

    private fun QueryDatabaseRequest.subject() = filter.select.equals
}
