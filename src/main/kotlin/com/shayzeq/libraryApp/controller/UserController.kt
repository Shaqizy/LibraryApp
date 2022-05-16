package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.dto.LoginDto
import com.shayzeq.libraryApp.dto.UserDto
import com.shayzeq.libraryApp.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<Any> {
        val id = userService.create(userDto)
        return ResponseEntity(InfoMessageDto("User with id = $id created successfully!"), HttpStatus.CREATED)
    }
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<Any> {
        val user = userService.findByLogin(loginDto.login)
            ?: return ResponseEntity.badRequest().body(InfoMessageDto("User with login ${loginDto.login} not found!"))

        if(!user.comparePassword(loginDto.password)) {
            return ResponseEntity.badRequest().body(InfoMessageDto("Invalid password!"))
        }

        return ResponseEntity(user, HttpStatus.OK)
    }

}