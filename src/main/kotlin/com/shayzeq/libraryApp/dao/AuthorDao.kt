package com.shayzeq.libraryApp.dao

import com.shayzeq.libraryApp.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorDao: CrudRepository<Author, String>