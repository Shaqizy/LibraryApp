package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.exception.BookNotFoundException
import com.shayzeq.libraryApp.model.Author
import com.shayzeq.libraryApp.model.Book
import com.shayzeq.libraryApp.model.Publisher
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookDao: BookDao
    ) : BookService{

    override fun getAllBooks(): List<BookDto> =
        bookDao.findAll().map { it.toDto() }

    override fun getById(id: String): BookDto =
        bookDao.findByIdOrNull(id)?.toDto()
            ?: throw BookNotFoundException(id)

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
//        val oldBook = bookDao.findById(id).orElseThrow().toDto()

    }

    override fun deleteById(id: String) {
        bookDao.deleteById(id)
    }

    private fun Book.toDto(): BookDto =
        BookDto(
            book_id = this.book_id,
            name = this.name,
            volume = this.volume,
            publicationYear = this.publicationYear,
            isbn = this.isbn,
            author = AuthorDto(
                author_id = this.author.author_id,
                firstName = this.author.firstName,
                lastName = this.author.lastName,
                country = this.author.country,
                birthdate = this.author.birthdate
            ),
            publisher = PublisherDto(
                publisher_id = this.publisher.publisher_id,
                name = this.publisher.name,
                city = this.publisher.city
            )
        )
}