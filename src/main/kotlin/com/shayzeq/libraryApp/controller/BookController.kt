package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.model.Book
import com.shayzeq.libraryApp.service.BookService
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
class BookController(val bookService: BookService) {

    @GetMapping
    fun getAllBooks(): ResponseEntity<List<BookDto>> {
        return ResponseEntity(bookService.getAllBooks(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): ResponseEntity<BookDto> {
        return ResponseEntity(bookService.getById(id), HttpStatus.OK)
    }

    @PostMapping("/new")
    fun createBook(@RequestBody book: BookDto): ResponseEntity<String> {
        bookService.create(book)
        return ResponseEntity(book.book_id, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: String): ResponseEntity<String> {
        bookService.deleteById(id)
        return ResponseEntity("Deleted successfully!", HttpStatus.OK)
    }
}