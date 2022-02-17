package com.shayzeq.libraryApp.dto

import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.TemporalType

@Entity
data class Book(
    @Id
    val book_id: String,
    val name: String,
    val volume: Int,
    @Temporal(TemporalType.DATE)
    val publicationYear: Date,
    val isbn: Int,
    val author_id: String,
    val publisher_id: String
)
