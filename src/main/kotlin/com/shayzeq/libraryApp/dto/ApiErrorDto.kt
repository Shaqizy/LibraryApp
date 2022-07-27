package com.shayzeq.libraryApp.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.Instant

data class ApiErrorDto(
    @Schema(title = "URL путь сервиса", example = "/books", required = true)
    val path: String,
    @Schema(title = "Сообщение ошибки", example = "", required = true)
    val message: String = "no message",
    @Schema(title = "traceID", example = "", required = true)
    val traceId: String = "no traceId",
    @Schema(title = "Время возникновения ошибки", example = "", required = true)
    val timestamp: Instant = Instant.now()
)
