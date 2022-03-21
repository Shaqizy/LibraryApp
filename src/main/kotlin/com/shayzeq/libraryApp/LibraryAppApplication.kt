package com.shayzeq.libraryApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.shayzeq.libraryApp"])
class LibraryAppApplication

fun main(args: Array<String>) {
	runApplication<LibraryAppApplication>(*args)
}

