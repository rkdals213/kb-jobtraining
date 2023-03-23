package com.example.kbjobtraining.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "notion")
data class NotionProperty(
    val databaseId: String = "",
    val notionVersion: String = "",
    val bearerToken: String = ""
)