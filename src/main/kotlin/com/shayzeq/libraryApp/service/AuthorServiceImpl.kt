package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.AuthorDao
import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.exception.NotFoundException
import com.shayzeq.libraryApp.mapper.AuthorMapper
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorDao: AuthorDao
    ) : AuthorService {

    val authorMapper: AuthorMapper = Mappers.getMapper(AuthorMapper::class.java)

    override fun getAllBooks(): List<AuthorDto>? {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): AuthorDto =
        authorMapper.mapToDto(authorDao.findByIdOrNull(id)
            ?: throw NotFoundException("Author with id = $id not found"))

    override fun create(authorDto: AuthorDto) {
        TODO("Not yet implemented")
    }

    override fun update(id: String, authorDto: AuthorDto) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}