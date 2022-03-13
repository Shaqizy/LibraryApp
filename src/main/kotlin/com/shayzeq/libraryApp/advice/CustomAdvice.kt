package com.shayzeq.libraryApp.advice

import com.shayzeq.libraryApp.exception.LibraryAbstractException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.Instant

@RestControllerAdvice
class CustomAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleBookNotFound(ex: LibraryAbstractException): ResponseEntity<ApiErrorDto> {
//        val message = String.format("%s %s", LocalDateTime.now(), ex.message)
        return ResponseEntity(ApiErrorDto("/books/{id}", ex.message), HttpStatus.NOT_FOUND)
    }
}

data class ApiErrorDto(
    val path: String,
    val message: String = "no message",
    val traceId: String = "no traceid",
    val timestamp: Instant = Instant.now()
)