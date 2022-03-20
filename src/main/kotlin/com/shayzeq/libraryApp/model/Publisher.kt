package com.shayzeq.libraryApp.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Publisher(
    @Id
    val publisher_id: String,
    var name: String?,
    var city: String?
)
