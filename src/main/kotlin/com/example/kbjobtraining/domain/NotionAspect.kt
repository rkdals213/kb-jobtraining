package com.example.kbjobtraining.domain

import com.example.kbjobtraining.dto.QueryDatabaseRequest
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.context.ApplicationEventPublisher

@Aspect
class NotionAspect(
    private val notionCacheRepository: NotionCacheRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    @Around("execution(* com.example.kbjobtraining.domain.Notion.findData(..))")
    fun execute(joinPoint: ProceedingJoinPoint): Any {
        val queryDatabaseRequest = joinPoint.args[0] as QueryDatabaseRequest
        val subject = Subject.findByContent(queryDatabaseRequest.subject())

        val notionCache = notionCacheRepository.findData(subject, queryDatabaseRequest)

        if (notionCache.expired()) {
            applicationEventPublisher.publishEvent(NotionCacheRepository.RefreshNotionCache(subject, queryDatabaseRequest))
        }

        return notionCache.content
    }

    private fun QueryDatabaseRequest.subject() = filter.select.equals
}