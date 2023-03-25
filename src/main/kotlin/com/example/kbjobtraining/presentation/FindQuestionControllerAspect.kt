package com.example.kbjobtraining.presentation

import com.example.kbjobtraining.measureTime
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import java.lang.System.*

@Aspect
class FindQuestionControllerAspect {

    @Around("execution(* com.example.kbjobtraining.presentation.FindQuestionController.findQuestions(..))")
    fun execute(joinPoint: ProceedingJoinPoint): Any {
        return measureTime("FindQuestionController.findQuestions()") { joinPoint.proceed() }
    }
}