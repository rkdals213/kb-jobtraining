package com.example.kbjobtraining.app.infrastructure

import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.QueryDatabaseResponse
import com.example.kbjobtraining.config.FeignClientHeaderConfiguration
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(value = "example", url = "https://api.notion.com", configuration = [FeignClientHeaderConfiguration::class])
interface NotionFeignClient {

    @PostMapping("/v1/databases/{id}/query")
    fun findQuestions(@PathVariable id: String, @RequestBody queryDatabaseRequest: QueryDatabaseRequest): QueryDatabaseResponse

}

