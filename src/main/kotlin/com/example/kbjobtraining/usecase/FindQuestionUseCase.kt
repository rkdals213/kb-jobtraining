package com.example.kbjobtraining.usecase

import com.example.kbjobtraining.domain.Notion
import com.example.kbjobtraining.domain.Subject
import com.example.kbjobtraining.dto.QueryDatabaseRequest
import com.example.kbjobtraining.dto.QueryDatabaseResponse
import org.springframework.stereotype.Component

@Component
class FindQuestionUseCase(
    private val notion: Notion,
) {

    data class InputValue(
        val subject: Subject,
    )

    fun execute(inputValue: InputValue): QueryDatabaseResponse {
        val queryDatabaseRequest = QueryDatabaseRequest(
            filter = QueryDatabaseRequest.Filter(
                property = "subject",
                select = QueryDatabaseRequest.Filter.Select(
                    equals = inputValue.subject.content
                )
            )
        )

        return notion.findData(queryDatabaseRequest)
    }
}