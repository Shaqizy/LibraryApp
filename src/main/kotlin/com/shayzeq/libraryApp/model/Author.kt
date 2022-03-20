package com.shayzeq.libraryApp.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @Column(name = "author_id", nullable = false)
    val author_id: String,

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
