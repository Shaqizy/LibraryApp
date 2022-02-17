package com.shayzeq.libraryApp.dto

import java.util.Date

data class Author(
    val author_id: String,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val country: String,
    val birthdate: Date
)
