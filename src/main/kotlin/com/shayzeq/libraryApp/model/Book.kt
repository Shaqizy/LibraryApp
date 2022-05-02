package com.shayzeq.libraryApp.model

import com.shayzeq.libraryApp.utils.StringIdGenerator
import org.hibernate.annotations.GenericGenerator
import org.hibernate.id.enhanced.SequenceStyleGenerator
import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @Column(name = "book_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_seq")
    @GenericGenerator(name = "publisher_seq",
        strategy = "com.shayzeq.libraryApp.utils.StringIdGenerator",
        parameters = [org.hibernate.annotations.Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "50"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "bk_"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")])
    val book_id: String?,

    @Column(name = "name", nullable = false)
    var name: String?,

    @Column(name = "volume", nullable = false)
    var volume: Int?,

    @Column(name = "publicationYear", nullable = false)
    @Temporal(TemporalType.DATE)
    var publicationYear: Date?,

    @Column(name = "isbn", nullable = false)
    var isbn: Int?,

    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    var author: Author?,

    @OneToOne(cascade = [CascadeType.MERGE], fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    var publisher: Publisher?
)
