package com.example.kbjobtraining.dto

data class QueryDatabaseRequest(
    val filter: Filter,
) {
    data class Filter(
        val property: String,
        val select: Select,
    ) {
        data class Select(
            val equals: String,
        )
    }
}

data class QueryDatabaseResponse(
    val results: List<Result>,
) {
    data class Result(
        val id: String,
        val properties: Properties,
    ) {
        data class Properties(
            val subject: Subject,
            val question: Question,
            val content1: Content,
            val content2: Content,
            val content3: Content,
            val content4: Content,
            val answer: Answer,
        ) {
            data class Subject(
                val id: String,
                val type: String,
                val select: Select,
            ) {
                data class Select(
                    val id: String,
                    val name: String,
                    val color: String,
                )
            }

            data class Question(
                val id: String,
                val type: String,
                val title: List<Title>,
            ) {
                data class Title(
                    val type: String,
                    val text: Text,
                )
            }

            data class Content(
                val id: String,
                val type: String,
                val rich_text: List<RichText>,
            )

            data class Answer(
                val id: String,
                val type: String,
                val number: Int,
            )
        }
    }
}

data class Text(
    val content: String,
)

data class RichText(
    val type: String,
    val text: Text,
)