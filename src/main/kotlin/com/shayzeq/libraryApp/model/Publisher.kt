package com.shayzeq.libraryApp.model

import com.shayzeq.libraryApp.utils.StringIdGenerator
import org.hibernate.annotations.GenericGenerator
import org.hibernate.id.enhanced.SequenceStyleGenerator
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher(
    @Id
    @Column(name = "publisher_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "publisher_seq")
    @GenericGenerator(name = "publisher_seq",
        strategy = "com.shayzeq.libraryApp.utils.StringIdGenerator",
        parameters = arrayOf(
            org.hibernate.annotations.Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "50"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.VALUE_PREFIX_PARAMETER, value = "pub_"),
            org.hibernate.annotations.Parameter(name = StringIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
        ))
    val publisher_id: String?,

    @Column(name = "name", nullable = false)
    var name: String?,

    @Column(name = "city", nullable = false)
    var city: String?
)
