package com.shayzeq.libraryApp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException(val id: String): BaseException(
    HttpStatus.NOT_FOUND,
    "book.not.found",
    "Book with id=$id not found"
)