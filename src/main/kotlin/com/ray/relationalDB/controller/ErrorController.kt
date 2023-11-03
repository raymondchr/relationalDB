package com.ray.relationalDB.controller

import com.ray.relationalDB.model.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IllegalArgumentException


@RestControllerAdvice
class ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value= [com.ray.relationalDB.error.NotFoundException::class])
    fun notFoundHandler(notFoundException: com.ray.relationalDB.error.NotFoundException): ErrorResponse {
        return ErrorResponse(
            code = 404,
            status = "Data Not Found"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    fun existInDB(illegalArgumentException: IllegalArgumentException): ErrorResponse{
        return ErrorResponse(
            code = 400,
            status = "Already Exist"
        )
    }
}