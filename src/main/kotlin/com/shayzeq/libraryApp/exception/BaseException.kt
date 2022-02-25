package com.shayzeq.libraryApp.exception

import org.springframework.http.HttpStatus

abstract class BaseException(
        val httpStatus: HttpStatus,
        val errorCode: String,
        val description: String
    ): RuntimeException(description)