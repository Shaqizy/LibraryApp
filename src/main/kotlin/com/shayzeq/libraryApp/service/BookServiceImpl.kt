package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.model.Author
import com.shayzeq.libraryApp.model.Book
import com.shayzeq.libraryApp.model.Publisher
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookDao: BookDao
    ) : BookService{
    override fun getAllBooks(): List<Book> =
        bookDao.findAll().toList()

    override fun getById(id: String): Book =
        bookDao.findById(id).orElseThrow()

    override fun create(book: BookDto) {
        val newBook = Book(
            book_id = book.book_id,
            name = book.name,
            volume = book.volume,
            publicationYear = book.publicationYear,
            isbn = book.isbn,
            author = Author(
                book.author.author_id,
                book.author.firstName,
                book.author.lastName,
                book.author.country,
                book.author.birthdate),
            publisher = Publisher(
                book.publisher.publisher_id,
                book.publisher.name,
                book.publisher.city
            )
        )
        bookDao.save(newBook)
    }

    override fun update(id: String, book: BookDto) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}