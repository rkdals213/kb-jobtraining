package com.example.back.presentation

import com.example.back.dto.FindQuestionResponse
import com.example.back.dto.QueryDatabaseResponse
import com.example.back.dto.Question
import com.example.back.usecase.FindQuestionUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = ["*"])
class FindQuestionController(
    private val findQuestionUseCase: FindQuestionUseCase,
) {

    @GetMapping
    fun findQuestions(inputValue: FindQuestionUseCase.InputValue): ResponseEntity<FindQuestionResponse> {
        val queryDatabaseResponse = findQuestionUseCase.execute(inputValue)

        val questions = mapFrom(queryDatabaseResponse)

        return ResponseEntity.ok(FindQuestionResponse(questions))
    }

    private fun mapFrom(response: QueryDatabaseResponse) = response.results
        .map {
            Question(
                subject = it.properties.subject.select.name,
                question = it.properties.question.title[0].text.content,
                content1 = it.properties.content1.rich_text[0].text.content,
                content2 = it.properties.content2.rich_text[0].text.content,
                content3 = it.properties.content3.rich_text[0].text.content,
                content4 = it.properties.content4.rich_text[0].text.content,
                answer = it.properties.answer.number
            )
        }.shuffled()
}