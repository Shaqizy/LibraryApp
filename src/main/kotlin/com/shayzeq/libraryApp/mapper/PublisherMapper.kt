package com.shayzeq.libraryApp.mapper

import com.shayzeq.libraryApp.dto.PublisherDto
import com.shayzeq.libraryApp.model.Publisher
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface PublisherMapper {

    fun mapToDto(publisher: Publisher): PublisherDto

    @Mapping(target = "publisher_id", ignore = true)
    fun mapToModel(publisherDto: PublisherDto): Publisher

}