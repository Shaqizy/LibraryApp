package com.shayzeq.libraryApp.mapper

import com.shayzeq.libraryApp.dto.BookDto
import com.shayzeq.libraryApp.model.Book
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface BookMapper {

    fun mapToDto(book: Book): BookDto

    fun mapToModel(bookDto: BookDto): Book
}