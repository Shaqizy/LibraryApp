package com.shayzeq.libraryApp.dto

import java.util.*

data class BookDto(
    val book_id: String,
    var name: String?,
    var volume: Int?,
    var publicationYear: Date?,
    var isbn: Int?,
    var author: AuthorDto?,
    var publisher: PublisherDto?
)
