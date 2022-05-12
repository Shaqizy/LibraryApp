package com.shayzeq.libraryApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.shayzeq.libraryApp"], exclude = [SecurityAutoConfiguration::class])
class LibraryAppApplication

fun main(args: Array<String>) {
	runApplication<LibraryAppApplication>(*args)
}

