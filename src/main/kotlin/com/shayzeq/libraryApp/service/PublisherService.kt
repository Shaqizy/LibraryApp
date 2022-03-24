package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dto.PublisherDto

interface PublisherService {

    fun getAllPublishers(): List<PublisherDto>?

    fun getById(id: String): PublisherDto

    fun create(publisherDto: PublisherDto)

    fun update(id: String, publisherDto: PublisherDto)

    fun deleteById(id: String)
}