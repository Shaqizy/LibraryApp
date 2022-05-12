package com.shayzeq.libraryApp.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0

    @Column(name = "login", unique = true, nullable = false)
    var login: String = ""

    @Column(name = "password", unique = true, nullable = false)
    var password: String = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    @Column(name = "firstName", nullable = true)
    var firstName: String? = null

    @Column(name = "lastName", nullable = true)
    var lastName: String? = null

    @Column(name = "age", nullable = true)
    var age: Int? = null

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }
}