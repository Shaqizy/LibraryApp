package com.shayzeq.libraryApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryAppApplication

fun main(args: Array<String>) {
	runApplication<LibraryAppApplication>(*args)
}

