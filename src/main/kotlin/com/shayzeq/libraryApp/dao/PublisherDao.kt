package com.shayzeq.libraryApp.dao

import com.shayzeq.libraryApp.model.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherDao: CrudRepository<Publisher, String> {
}