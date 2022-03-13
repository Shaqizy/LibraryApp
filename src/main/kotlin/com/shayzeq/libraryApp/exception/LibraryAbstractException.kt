package com.shayzeq.libraryApp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

abstract class LibraryAbstractException (
    open val httpStatus: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    override val message: String = "default.message",
    open vararg val args: Any = emptyArray()
) : ResponseStatusException(httpStatus, message)