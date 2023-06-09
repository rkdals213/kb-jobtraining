package com.example.kbjobtraining.app.dto

data class FindQuestionResponse(
    val result: List<Question>,
)

data class Question(
    val subject: String,
    val question: String,
    val content1: String,
    val content2: String,
    val content3: String,
    val content4: String,
    val answer: Int,
    val comment: String,
)