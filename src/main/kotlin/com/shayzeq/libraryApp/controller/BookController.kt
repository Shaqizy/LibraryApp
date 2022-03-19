package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.exception.BookNotFoundException
import com.shayzeq.libraryApp.service.BookService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
@Tag(name = "Book controller для работы с книгами в библиотеке")
class BookController(val bookService: BookService) {

    @GetMapping
    @Operation(summary = "Получение списка всех книг")
    fun getAllBooks(): ResponseEntity<List<BookDto>> {
        return ResponseEntity(bookService.getAllBooks(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение книги по ее идентификатору")
    fun getBookById(@PathVariable id: String): ResponseEntity<Any> {
        val bookDto: BookDto = bookService.getById(id)
        return ResponseEntity(bookDto, HttpStatus.OK)
    }

    @PostMapping("/new")
    @Operation(summary = "Создание новой книги")
    fun createBook(@RequestBody book: BookDto): ResponseEntity<Any> {
        bookService.create(book)
        return ResponseEntity(InfoMessageDto("Book with id = ${book.book_id} created successfully!"), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление книги по ее идентификатору")
    fun deleteBook(@PathVariable id: String): ResponseEntity<Any> {
        bookService.deleteById(id)
        return ResponseEntity(InfoMessageDto("Deleted Book with id = $id successfully!"), HttpStatus.OK)
    }
}