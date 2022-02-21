package com.shayzeq.libraryApp.model

import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
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
    @OneToOne
    @JoinColumn(name = "author_id")
    val author: Author,
    @OneToOne
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher
)
