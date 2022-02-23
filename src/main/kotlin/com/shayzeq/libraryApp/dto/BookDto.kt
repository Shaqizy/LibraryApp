package com.shayzeq.libraryApp.dto

import java.util.*

data class BookDto(
    val book_id: String,
    val name: String,
    val volume: Int,
    val publicationYear: Date,
    val isbn: Int,
    val author: AuthorDto,
    val publisher: PublisherDto
)
