package com.shayzeq.libraryApp.dao

import com.shayzeq.libraryApp.dto.Book
import org.springframework.data.repository.CrudRepository

interface BookDao: CrudRepository<Book, String> {
}