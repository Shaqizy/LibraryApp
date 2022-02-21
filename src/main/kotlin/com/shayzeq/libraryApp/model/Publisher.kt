package com.shayzeq.libraryApp.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Publisher(
    @Id
    val publisher_id: String,
    val name: String,
    val city: String
)
