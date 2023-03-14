package com.example.kbjobtraining.domain

import com.example.kbjobtraining.dto.QueryDatabaseRequest
import com.example.kbjobtraining.dto.QueryDatabaseResponse
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import java.time.LocalDateTime

@Aspect
class NotionAspect(
    private val notionCacheRepository: NotionCacheRepository,
) {

    private val log = LoggerFactory.getLogger(NotionAspect::class.java)

    @Around("execution(* com.example.kbjobtraining.domain.Notion.findData(..))")
    fun execute(joinPoint: ProceedingJoinPoint): Any? {
        val queryDatabaseRequest = joinPoint.args[0] as QueryDatabaseRequest
        val equals = queryDatabaseRequest.filter
            .select
            .equals
        val subject = Subject.findByContent(equals)

        val notionCache = notionCacheRepository.findData(subject)

        if (notionCache == null || notionCache.expired()) {
            log.info("Data from notion api = $subject")

            val queryDatabaseResponse = joinPoint.proceed() as QueryDatabaseResponse
            val newNotionCache = NotionCache(LocalDateTime.now().plusMinutes(5), queryDatabaseResponse)
            notionCacheRepository.refresh(subject, newNotionCache)

            return queryDatabaseResponse
        }

        return notionCache.content
    }
}