package com.example.kbjobtraining

import com.example.kbjobtraining.config.NotionProperty
import com.example.kbjobtraining.app.domain.NotionCacheRepository
import com.example.kbjobtraining.app.domain.Subject
import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.stereotype.Component

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(NotionProperty::class)
@ConfigurationPropertiesScan
@EnableAsync
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

@Component
class InitService(
    private val notionCacheRepository: NotionCacheRepository,
) {

    @PostConstruct
    fun init() {
        Subject.values().forEach {
            val queryDatabaseRequest = QueryDatabaseRequest(
                filter = QueryDatabaseRequest.Filter(
                    property = "subject",
                    select = QueryDatabaseRequest.Filter.Select(
                        equals = it.content
                    )
                )
            )

            notionCacheRepository.findData(it, queryDatabaseRequest)
        }
    }
}