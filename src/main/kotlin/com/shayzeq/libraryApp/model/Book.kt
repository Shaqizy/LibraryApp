package com.shayzeq.libraryApp.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
data class Book(
    @Id
    val book_id: String,
    var name: String?,
    var volume: Int?,
    @Temporal(TemporalType.DATE)
    var publicationYear: Date?,
    var isbn: Int?,
    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    var author: Author?,
    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    var publisher: Publisher?
)
