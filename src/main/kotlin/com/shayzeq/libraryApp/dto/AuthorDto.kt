package com.shayzeq.libraryApp.dto

import java.util.*

data class AuthorDto(
    val author_id: String,
    var firstName: String?,
    var lastName: String?,
    var country: String?,
    var birthdate: Date?
)
