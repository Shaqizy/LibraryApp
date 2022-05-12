package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.service.AuthorService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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
    @GetMapping
    @Operation(summary = "Получения списка всех авторов")
    fun getAllBooks(): ResponseEntity<List<AuthorDto>> {
        return ResponseEntity(authorService.getAllAuthors(), HttpStatus.OK)
    }
    @PostMapping("/new")
    @Operation(summary = "Создание нового автора")
    fun createAuthor(@RequestBody authorDto: AuthorDto): ResponseEntity<Any> {
        val id = authorService.create(authorDto)
        return ResponseEntity(InfoMessageDto("Author with id = $id created successfully!"), HttpStatus.CREATED)
    }

}