package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.BookDto

interface BookService {

    fun getAllBooks(): List<BookDto>

    fun getById(id: String): BookDto

    fun create(book: BookDto)

    fun update(id: String, book: BookDto)

    fun deleteById(id: String)
}