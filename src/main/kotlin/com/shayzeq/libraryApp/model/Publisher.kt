package com.shayzeq.libraryApp.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    @Column(name = "publisher_id", nullable = false)
    val publisher_id: String,

    @Column(name = "name", nullable = false)
    var name: String?,

    @Column(name = "city", nullable = false)
    var city: String?
)
