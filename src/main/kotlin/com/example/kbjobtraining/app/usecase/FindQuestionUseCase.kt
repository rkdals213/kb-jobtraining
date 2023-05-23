package com.example.kbjobtraining.app.usecase

import com.example.kbjobtraining.app.domain.NotionRepository
import com.example.kbjobtraining.app.domain.Subject
import com.example.kbjobtraining.app.dto.QueryDatabaseRequest
import com.example.kbjobtraining.app.dto.QueryDatabaseResponse
import org.springframework.stereotype.Component

@Component
class FindQuestionUseCase(
    private val notionRepository: NotionRepository,
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

        return notionRepository.findData(queryDatabaseRequest)
    }
}