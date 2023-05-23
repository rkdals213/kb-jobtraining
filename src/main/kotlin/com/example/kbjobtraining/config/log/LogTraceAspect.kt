package com.example.kbjobtraining.config.log

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class LogTraceAspect(
    private val logTrace: LogTrace
) {

    @Around("execution(* com.example.kbjobtraining.app..*(..))")
    @Throws(Throwable::class)
    fun execute(joinPoint: ProceedingJoinPoint): Any? {
        val message = joinPoint.signature.toShortString()
        val status = logTrace.begin(message)

        return runCatching {
            joinPoint.proceed()
        }.onSuccess {
            logTrace.end(status)
        }.onFailure {
            logTrace.exception(status, it.message ?: "알수없는 오류 발생")
        }.getOrNull()
    }
}