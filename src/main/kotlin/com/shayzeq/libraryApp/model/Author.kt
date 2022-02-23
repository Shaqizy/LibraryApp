package com.shayzeq.libraryApp.model

import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.TemporalType

@Entity
data class Author(
    @Id
    val author_id: String,
    val firstName: String,
    val lastName: String,
    val country: String,
    @Temporal(TemporalType.DATE)
    val birthdate: Date
)
