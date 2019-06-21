package com.eluminum.starwars.error

import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.ServletRequest


@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandlerHandler(servletRequest: ServletRequest, exception: Exception): ResponseEntity<ErrorResponse>{
        return ResponseEntity(ErrorResponse("JSON ERROR", "invalid json"), HttpStatus.BAD_REQUEST)
    }
    fun PlanetNotFoundExceptionHandler(servletRequest: ServletRequest, exception: Exception): ResponseEntity<ErrorResponse> {
       return ResponseEntity(ErrorResponse("Planet Not Found", exception.message!!), HttpStatus.NOT_FOUND)
    }
}