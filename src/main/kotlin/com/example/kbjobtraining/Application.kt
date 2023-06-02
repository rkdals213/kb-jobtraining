package com.example.kbjobtraining

import com.example.kbjobtraining.app.domain.NotionRepository
import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.Subject
import com.example.kbjobtraining.config.NotionProperty
import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Profile
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
@Profile(value = ["local", "prod"])
class InitService(
    private val notionRepository: NotionRepository,
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

            notionRepository.findData(queryDatabaseRequest)
        }
    }
}