package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.UserDto

interface UserService {

    fun create(userDto: UserDto): Int

    fun update(id: Int, userDto: UserDto)

    fun getById(id: Int): UserDto
}