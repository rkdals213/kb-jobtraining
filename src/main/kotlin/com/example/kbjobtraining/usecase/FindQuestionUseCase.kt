package com.example.back.usecase

import com.example.back.dto.QueryDatabaseRequest
import com.example.back.dto.QueryDatabaseResponse
import com.example.back.domain.Notion
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

    enum class Subject(
        val content: String,
    ) {
        SUBJECT_ONE("상품판매"),
        SUBJECT_TWO("외환"),
        SUBJECT_THREE("상품판매"),
        SUBJECT_FOUR("상품판매")
        ;
    }
}