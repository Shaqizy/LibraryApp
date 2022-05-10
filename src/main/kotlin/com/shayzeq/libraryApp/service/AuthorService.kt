package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.AuthorDto

interface AuthorService {

    fun getAllAuthors(): List<AuthorDto>?

    fun getById(id: String): AuthorDto

    fun create(authorDto: AuthorDto)

    fun update(id: String, authorDto: AuthorDto)

    fun deleteById(id: String)
}