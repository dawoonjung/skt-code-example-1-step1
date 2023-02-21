package com.group.libraryapp.controller.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleException() : ResponseEntity<String> {
        return ResponseEntity.ok("sorry");
    }

    @ExceptionHandler(UserController.SKTBaseException::class)
    fun handleSKTBaseException(e :UserController.SKTBaseException):String? {
        return e.message
    }
}