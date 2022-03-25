package com.shayzeq.libraryApp.mapper

import com.shayzeq.libraryApp.dto.AuthorDto
import com.shayzeq.libraryApp.model.Author
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface AuthorMapper {

    fun mapToDto(author: Author): AuthorDto

    fun mapToModel(authorDto: AuthorDto): Author
}