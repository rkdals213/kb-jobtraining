package com.example.kbjobtraining.domain

import org.springframework.stereotype.Repository

@Repository
class NotionCacheRepository {

    private val cache: MutableMap<Subject, NotionCache> = mutableMapOf()

    fun findData(subject: Subject): NotionCache? {
        return cache[subject]
    }

    fun refresh(subject: Subject, newNotionCache: NotionCache) {
        cache[subject] = newNotionCache
        cache.entries.forEach { println(it.key) }

    }
}