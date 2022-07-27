package com.shayzeq.libraryApp.advice

import com.shayzeq.libraryApp.dto.ApiErrorDto
import com.shayzeq.libraryApp.exception.NotFoundException
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

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleBookNotFound(ex: LibraryAbstractException, httpServletRequest: HttpServletRequest): ResponseEntity<ApiErrorDto> {
        return ResponseEntity(ApiErrorDto(httpServletRequest.requestURI, ex.message), HttpStatus.NOT_FOUND)
    }
}