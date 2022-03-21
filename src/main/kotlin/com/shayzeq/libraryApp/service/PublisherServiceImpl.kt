package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.PublisherDao
import com.shayzeq.libraryApp.dto.PublisherDto
import org.springframework.stereotype.Service

@Service
class PublisherServiceImpl(
    private val publisherDao: PublisherDao
    ) : PublisherService {

    override fun getAllPublishers(): List<PublisherDto>? {
        TODO("Not yet implemented")
    }

    override fun getById(id: String): PublisherDto {
        TODO("Not yet implemented")
    }

    override fun create(publisherDto: PublisherDto) {
        TODO("Not yet implemented")
    }

    override fun update(id: String, publisherDto: PublisherDto) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}