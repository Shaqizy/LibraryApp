package com.shayzeq.libraryApp.service

import com.shayzeq.libraryApp.dao.PublisherDao
import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.exception.NotFoundException
import com.shayzeq.libraryApp.mapper.PublisherMapper
import org.mapstruct.factory.Mappers
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PublisherServiceImpl(
    private val publisherDao: PublisherDao
    ) : PublisherService {

    val publisherMapper: PublisherMapper = Mappers.getMapper(PublisherMapper::class.java)

    override fun getAllPublishers(): List<PublisherDto>? =
        publisherDao.findAll().map { publisherMapper.mapToDto(it ?: throw NotFoundException("Publisher list is empty")) }

    override fun getById(id: String): PublisherDto =
        publisherMapper.mapToDto(publisherDao.findByIdOrNull(id)
            ?: throw NotFoundException("Publisher with id = $id not found"))

    override fun create(publisherDto: PublisherDto) {
        publisherDao.save(publisherMapper.mapToModel(publisherDto))
    }

    override fun update(id: String, publisherDto: PublisherDto) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String) {
        TODO("Not yet implemented")
    }
}