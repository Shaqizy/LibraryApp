package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.service.PublisherService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/publishers")
@Tag(name = "Publisher controller для работы с издательствами в библиотеке")
class PublisherController(val publisherService: PublisherService) {

    @GetMapping
    @Operation(summary = "Получение списка всех издательств")
    fun getAllBooks(): ResponseEntity<List<PublisherDto>> =
        ResponseEntity(publisherService.getAllPublishers(), HttpStatus.OK)


    @GetMapping("/{id}")
    @Operation(summary = "Получение издательства по индентификатору")
    fun getPublisherById(@PathVariable id: String): ResponseEntity<PublisherDto> =
        ResponseEntity(publisherService.getById(id), HttpStatus.OK)

    @PostMapping("/new")
    @Operation(summary = "Создание нового издательства")
    fun createPublisher(@RequestBody publisherDto: PublisherDto): ResponseEntity<InfoMessageDto> {
        publisherService.create(publisherDto)
        return ResponseEntity(InfoMessageDto("Publisher created successfully!"), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение издательства по идентификатору")
    fun updatePublisher(@PathVariable id: String, @RequestBody publisherDto: PublisherDto): ResponseEntity<InfoMessageDto> {
        publisherService.update(id, publisherDto)
        return ResponseEntity(InfoMessageDto("Publisher by id = $id updated!"), HttpStatus.OK)
    }
}