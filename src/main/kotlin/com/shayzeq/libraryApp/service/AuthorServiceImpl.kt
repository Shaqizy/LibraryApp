package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.AuthorDao
import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.exception.NotFoundException
import com.shayzeq.libraryApp.mapper.AuthorMapper
import com.shayzeq.libraryApp.model.Author
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorDao: AuthorDao
    ) : AuthorService {

    val authorMapper: AuthorMapper = Mappers.getMapper(AuthorMapper::class.java)

    override fun getAllAuthors(): List<AuthorDto>? =
        authorDao.findAll().map { authorMapper.mapToDto(it ?: throw NotFoundException("Author list is empty")) }

    override fun getById(id: String): AuthorDto =
        authorMapper.mapToDto(authorDao.findByIdOrNull(id)
            ?: throw NotFoundException("Author with id = $id not found"))

    override fun create(authorDto: AuthorDto) {
        authorDao.save(authorMapper.mapToModel(authorDto))
    }

    override fun update(id: String, authorDto: AuthorDto) {
        val existingAuthor: Author = authorDao.findByIdOrNull(id)
            ?: throw NotFoundException("Author with id = $id not found")
        val futureAuthor = authorMapper.mapToModel(authorDto)
        existingAuthor.firstName = futureAuthor.firstName ?: existingAuthor.firstName
        existingAuthor.lastName = futureAuthor.lastName ?: existingAuthor.lastName
        existingAuthor.country = futureAuthor.country ?: existingAuthor.country
        existingAuthor.birthdate = futureAuthor.birthdate ?: existingAuthor.birthdate
    }

    override fun deleteById(id: String) {
        val existingAuthor: Author = authorDao.findByIdOrNull(id)
            ?: throw NotFoundException("Author with id = $id not found")
        authorDao.deleteById(existingAuthor.author_id!!)
    }
}