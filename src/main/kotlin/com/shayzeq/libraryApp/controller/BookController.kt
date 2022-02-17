package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.Book
import com.shayzeq.libraryApp.service.BookService
import com.shayzeq.libraryApp.service.BookServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(val bookService: BookService) {

    @GetMapping
    fun getAllBooks(): List<Book> = bookService.getAllBooks()
}