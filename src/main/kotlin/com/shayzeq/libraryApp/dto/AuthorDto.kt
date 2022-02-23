package com.shayzeq.libraryApp.dto

import java.util.*

data class AuthorDto(
    val author_id: String,
    val firstName: String,
    val lastName: String,
    val country: String,
    val birthdate: Date
)
