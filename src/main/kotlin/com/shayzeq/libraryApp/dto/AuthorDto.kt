package com.shayzeq.libraryApp.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.util.*

data class AuthorDto(

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, required = false, example = "aut_00001")
    val author_id: String?,
    @Schema(title = "Имя автора", example = "Вадим", required = true)
    var firstName: String?,
    @Schema(title = "Фамилия автора", example = "Зеланд", required = true)
    var lastName: String?,
    @Schema(title = "Страна рождения", example = "Россия", required = true)
    var country: String?,
    @Schema(title = "Дата рождения", example = "1980-04-18", required = true)
    var birthdate: Date?
)
