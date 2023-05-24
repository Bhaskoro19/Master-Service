package com.latihan.masterservice.exception

import com.latihan.masterservice.domain.dto.response.global.ResMessageDto
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.IOException
import java.security.GeneralSecurityException
import javax.validation.ValidationException

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class RestExceptionHandler {

    @ExceptionHandler(
            IOException::class,
            BadRequestException::class,
            GeneralSecurityException::class,
            IOException::class,
            HttpMessageNotReadableException::class,
            IllegalArgumentException::class,
            RequiredFieldIsMissingException::class,
            AuthorizationException::class,
            RequiredFieldNotValidException::class
    )
    fun userNotFoundException(exception:RuntimeException): ResponseEntity<ResMessageDto> {
        return ResponseEntity.badRequest().body(ResMessageDto(
                HttpStatus.BAD_REQUEST.value(),
                exception.message!!, null,
        ))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException (exception: MethodArgumentNotValidException): ResponseEntity<ResMessageDto> {
        val errors: ArrayList<String> = ArrayList()
        exception.bindingResult.fieldErrors.forEach {
            errors.add(it.defaultMessage!!)
        }

        return ResponseEntity.badRequest().body(ResMessageDto(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid required field constraints", errors))
    }

    @ExceptionHandler(ValidationException::class)
    fun handleValidationException(exception: RuntimeException) : ResponseEntity<ResMessageDto> {
//        log.info("ERROR NOT VALID EXCEPTION!!")
        var message:String
        if (exception.message != null) {
            message = exception.message!!
        } else {
            message = "Error"
        }
        return ResponseEntity.badRequest().body(ResMessageDto(
                HttpStatus.BAD_REQUEST.value(),
                message, null
        ))
    }
}