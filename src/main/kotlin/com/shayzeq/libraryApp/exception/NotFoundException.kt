package com.shayzeq.libraryApp.exception

import org.springframework.http.HttpStatus

class NotFoundException(
    message: String
): LibraryAbstractException(HttpStatus.NOT_FOUND, message)
