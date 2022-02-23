package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.model.Book

interface BookService {

    fun getAllBooks(): List<Book>

    fun getById(id: String): Book

    fun create(book: BookDto)

    fun update(id: String, book: BookDto)

    fun deleteById(id: String)
}