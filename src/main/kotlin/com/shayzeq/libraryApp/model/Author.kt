package com.shayzeq.libraryApp.model

import com.shayzeq.libraryApp.utils.StringIdGenerator
import org.hibernate.annotations.GenericGenerator
import org.hibernate.id.enhanced.SequenceStyleGenerator
import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @Column(name = "author_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "author_seq")
    @GenericGenerator(name = "author_seq",
        strategy = "com.shayzeq.libraryApp.utils.StringIdGenerator",
        parameters = [org.hibernate.annotations.Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "50"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "aut_"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")])
    val author_id: String?,

    @Column(name = "firstName", nullable = false)
    var firstName: String?,

    @Column(name = "lastName", nullable = false)
    var lastName: String?,

    @Column(name = "country", nullable = false)
    var country: String?,

    @Column(name = "birthdate", nullable = false)
    @Temporal(TemporalType.DATE)
    var birthdate: Date?
)
