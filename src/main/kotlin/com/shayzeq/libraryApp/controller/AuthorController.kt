package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.service.AuthorService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authors")
@Tag(name = "Author controller для работы с авторами в библиотеке")
class AuthorController(val authorService: AuthorService) {

    @GetMapping("/{id}")
    @Operation(summary = "Получение автора по ее идентификатору")
    fun getAuthorById(@PathVariable id: String): ResponseEntity<Any> {
        val authorDto: AuthorDto = authorService.getById(id)
        return ResponseEntity(authorDto, HttpStatus.OK)
    }
}