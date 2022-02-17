package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.Book

interface BookService {

    fun getAllBooks(): List<Book>

    fun getById(id: Int): Book

    fun create(book: Book)

    fun update(id: Int, book: Book)

    fun deleteById(id: Int)
}