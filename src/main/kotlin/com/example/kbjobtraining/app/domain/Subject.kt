package com.example.kbjobtraining.app.domain

enum class Subject(
    val content: String,
) {
    SUBJECT_ONE("상품판매"),
    SUBJECT_TWO("외환"),
    SUBJECT_THREE("과목 3"),
    SUBJECT_FOUR("과목 4")
    ;

    companion object {
        fun findByContent(content: String): Subject = values().first { it.content == content }
    }
}