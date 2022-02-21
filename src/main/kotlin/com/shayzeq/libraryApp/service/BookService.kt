package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.model.Book

interface BookService {

    fun getAllBooks(): List<Book>

    fun getById(id: String): Book

    fun create(book: Book)

    fun update(id: String, book: Book)

    fun deleteById(id: String)
}