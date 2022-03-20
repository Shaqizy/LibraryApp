package com.shayzeq.libraryApp.model

import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @Column(name = "book_id", nullable = false)
    val book_id: String,

    @Column(name = "name", nullable = false)
    var name: String?,

    @Column(name = "volume", nullable = false)
    var volume: Int?,

    @Column(name = "publicationYear", nullable = false)
    @Temporal(TemporalType.DATE)
    var publicationYear: Date?,

    @Column(name = "isbn", nullable = false)
    var isbn: Int?,

    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    var author: Author?,

    @OneToOne(cascade = arrayOf(CascadeType.MERGE), fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    var publisher: Publisher?
)
