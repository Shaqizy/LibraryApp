package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.model.Book
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookDao: BookDao
    ) : BookService{
    override fun getAllBooks(): List<Book> =
        bookDao.findAll().toList()

    override fun getById(id: String): Book =
        bookDao.findById(id).orElseThrow()

    override fun create(book: Book) {
        TODO("Not yet implemented")
    }

    override fun update(id: String, book: Book) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}