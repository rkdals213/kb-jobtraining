package com.example.kbjobtraining.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "notion")
data class NotionProperty(
    var databaseId: String,
    var notionVersion: String,
    var bearerToken: String
)