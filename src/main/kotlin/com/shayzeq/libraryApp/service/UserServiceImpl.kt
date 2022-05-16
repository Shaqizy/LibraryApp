package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.UserDao
import com.shayzeq.libraryApp.dto.UserDto
import com.shayzeq.libraryApp.model.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userDao: UserDao
    ) : UserService {

    override fun create(userDto: UserDto): Int {
        val user = User()
        user.login = userDto.login
        user.password = userDto.password
        user.firstName = userDto.firstName
        user.lastName = userDto.lastName
        user.age = userDto.age
        val newUser = userDao.save(user)
        return newUser.id
    }

    override fun findByLogin(login: String): User? {
        return userDao.findByLogin(login)
    }

    override fun update(id: Int, userDto: UserDto) {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): UserDto {
        TODO("Not yet implemented")
    }
}