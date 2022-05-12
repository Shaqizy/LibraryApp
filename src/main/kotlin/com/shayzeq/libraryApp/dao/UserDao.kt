package com.shayzeq.libraryApp.dao

import com.shayzeq.libraryApp.model.User
import org.springframework.data.repository.CrudRepository

interface UserDao: CrudRepository<User, Int>