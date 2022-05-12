package com.shayzeq.libraryApp.dto

data class UserDto(
    val id: Int?,
    val login: String,
    val password: String,
    var firstName: String?,
    var lastName: String?,
    var age: Int?
)
