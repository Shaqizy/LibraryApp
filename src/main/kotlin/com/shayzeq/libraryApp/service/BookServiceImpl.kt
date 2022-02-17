package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.dto.Book
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookDao: BookDao
    ) : BookService{
    override fun getAllBooks(): List<Book> =
        bookDao.findAll().toList()

    override fun getById(id: Int): Book {
        TODO("Not yet implemented")
    }

    override fun create(book: Book) {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, book: Book) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }
}