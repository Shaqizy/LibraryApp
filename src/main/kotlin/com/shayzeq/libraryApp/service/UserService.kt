package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.UserDto
import com.shayzeq.libraryApp.model.User

interface UserService {

    fun create(userDto: UserDto): Int

    fun findByLogin(login: String): User?

    fun update(id: Int, userDto: UserDto)

    fun getById(id: Int): UserDto
}