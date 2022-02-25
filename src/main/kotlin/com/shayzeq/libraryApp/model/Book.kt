package com.shayzeq.libraryApp.model

import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
data class Book(
    @Id
    val book_id: String,
    val name: String,
    val volume: Int,
    @Temporal(TemporalType.DATE)
    val publicationYear: Date,
    val isbn: Int,
    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    val author: Author,
    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    val publisher: Publisher
)
