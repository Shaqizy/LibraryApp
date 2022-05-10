package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.BookDao
import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.exception.NotFoundException
import com.shayzeq.libraryApp.mapper.BookMapper
import com.shayzeq.libraryApp.model.Book
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookDao: BookDao
    ) : BookService{

    val bookMapper: BookMapper = Mappers.getMapper(BookMapper::class.java)

    override fun getAllBooks(): List<BookDto> =
        bookDao.findAll().map { bookMapper.mapToDto(it ?: throw NotFoundException("Book list is empty")) }

    override fun getById(id: String): BookDto =
        bookMapper.mapToDto(bookDao.findByIdOrNull(id)
            ?: throw NotFoundException("Book with id = $id not found"))

    override fun create(book: BookDto) {
        bookDao.save(bookMapper.mapToModel(book))
    }

    override fun update(id: String, book: BookDto) {
        val existingBook: Book = bookDao.findByIdOrNull(id)
            ?: throw NotFoundException("Book with id = $id not found")
        val futureBook = bookMapper.mapToModel(book)
        existingBook.name = futureBook.name ?: existingBook.name
        existingBook.volume = futureBook.volume ?: existingBook.volume
        existingBook.publicationYear = futureBook.publicationYear ?: existingBook.publicationYear
        existingBook.isbn = futureBook.isbn ?: existingBook.isbn
        existingBook.author = futureBook.author ?: existingBook.author
        existingBook.publisher = futureBook.publisher ?: existingBook.publisher
        bookDao.save(existingBook)
    }

    override fun deleteById(id: String) {
        val existingBook: Book = bookDao.findByIdOrNull(id)
            ?: throw NotFoundException("Book with id = $id not found")
        bookDao.deleteById(existingBook.book_id!!)
    }

}