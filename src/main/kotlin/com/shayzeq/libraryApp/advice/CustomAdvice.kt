package com.shayzeq.libraryApp.advice

import com.shayzeq.libraryApp.exception.BookNotFoundException
import com.shayzeq.libraryApp.exception.LibraryAbstractException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

import java.time.Instant
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class CustomAdvice {

    @ExceptionHandler(BookNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleBookNotFound(ex: LibraryAbstractException, httpServletRequest: HttpServletRequest): ResponseEntity<ApiErrorDto> {
        return ResponseEntity(ApiErrorDto(httpServletRequest.requestURI, ex.message), HttpStatus.NOT_FOUND)
    }
}

data class ApiErrorDto(
    val path: String,
    val message: String = "no message",
    val traceId: String = "no traceid",
    val timestamp: Instant = Instant.now()
)