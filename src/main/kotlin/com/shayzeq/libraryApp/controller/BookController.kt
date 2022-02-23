package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.model.Book
import com.shayzeq.libraryApp.service.BookService
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
    fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: String): Book {
        return bookService.getById(id)
    }

    @PostMapping("/new")
    fun createBook(@RequestBody book: BookDto) {
        bookService.create(book)
    }
}