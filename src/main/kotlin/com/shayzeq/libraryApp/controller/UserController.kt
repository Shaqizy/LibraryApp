package com.shayzeq.libraryApp.controller

import com.shayzeq.libraryApp.dto.InfoMessageDto
import com.shayzeq.libraryApp.dto.LoginDto
import com.shayzeq.libraryApp.dto.UserDto
import com.shayzeq.libraryApp.model.User
import com.shayzeq.libraryApp.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<Any> {
        val id = userService.create(userDto)
        return ResponseEntity(InfoMessageDto("User with id = $id created successfully!"), HttpStatus.CREATED)
    }
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto, response: HttpServletResponse): ResponseEntity<Any> {
        val user = userService.findByLogin(loginDto.login)
            ?: return ResponseEntity.badRequest().body(InfoMessageDto("User with login ${loginDto.login} not found!"))

        if(!user.comparePassword(loginDto.password)) {
            return ResponseEntity.badRequest().body(InfoMessageDto("Invalid password!"))
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60* 2 * 1000)) // 2 hour
            .signWith(SignatureAlgorithm.HS256, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity(InfoMessageDto("success login"), HttpStatus.OK)
    }

    @GetMapping("/user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        if (jwt == null){
            return ResponseEntity(InfoMessageDto("Unauthorized user!"), HttpStatus.UNAUTHORIZED)
        }
        val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
        return ResponseEntity(userService.getById(body.issuer.toInt()), HttpStatus.OK)
    }

}