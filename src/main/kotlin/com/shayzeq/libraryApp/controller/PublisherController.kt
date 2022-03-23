package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.service.PublisherService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/publishers")
@Tag(name = "Publisher controller для работы с издательствами в библиотеке")
class PublisherController(val publisherService: PublisherService) {

    @GetMapping
    @Operation(summary = "Получение списка всех издательств")
    fun getAllBooks(): ResponseEntity<List<PublisherDto>> {
        return ResponseEntity(publisherService.getAllPublishers(), HttpStatus.OK)
    }

    @PostMapping("/new")
    @Operation(summary = "Создание нового издательства")
    fun createPublisher(@RequestBody publisherDto: PublisherDto): ResponseEntity<Any> {
        publisherService.create(publisherDto)
        return ResponseEntity(InfoMessageDto("Publisher with id = ${publisherDto.publisher_id} created successfully!"), HttpStatus.CREATED)
    }
}