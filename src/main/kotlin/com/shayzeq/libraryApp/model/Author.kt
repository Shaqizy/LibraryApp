package com.shayzeq.libraryApp.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.jpa.repository.Temporal
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.TemporalType

@Entity
data class Author(
    @Id
    val author_id: String,
    var firstName: String?,
    var lastName: String?,
    var country: String?,
    @Temporal(TemporalType.DATE)
    var birthdate: Date?
)
