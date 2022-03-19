package com.shayzeq.libraryApp.exception

import org.springframework.http.HttpStatus

class BookNotFoundException(
    message: String
): LibraryAbstractException(HttpStatus.NOT_FOUND, message)

//class BookNotFoundException(
//    id: String
//): LibraryAbstractException(HttpStatus.NOT_FOUND, "Book with id = $id not found")