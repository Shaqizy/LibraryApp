package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.exception.BookNotFoundException
import com.shayzeq.libraryApp.exception.LibraryAbstractException
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
        bookDao.findAll().map { it?.toDto() ?: throw BookNotFoundException("Book list is empty") }

    override fun getById(id: String): BookDto =
        bookDao.findByIdOrNull(id)?.toDto()
            ?: throw BookNotFoundException("Book with id = $id not found")

    override fun create(book: BookDto) {
        bookDao.save(book.fromDto())
    }

    override fun update(id: String, book: BookDto) {
//        val oldBook = bookDao.findById(id).orElseThrow().toDto()

    }

    override fun deleteById(id: String) {
        val existingBook: Book = bookDao.findByIdOrNull(id)
            ?: throw BookNotFoundException("Book with id = $id not found")
        bookDao.deleteById(existingBook.book_id)
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

    private fun BookDto.fromDto(): Book =
        Book(
            book_id = this.book_id,
            name = this.name,
            volume = this.volume,
            publicationYear = this.publicationYear,
            isbn = this.isbn,
            author = Author(
                author_id = this.author.author_id,
                firstName = this.author.firstName,
                lastName = this.author.lastName,
                country = this.author.country,
                birthdate = this.author.birthdate
            ),
            publisher = Publisher(
                publisher_id = this.publisher.publisher_id,
                name = this.publisher.name,
                city = this.publisher.city
            )
        )
}