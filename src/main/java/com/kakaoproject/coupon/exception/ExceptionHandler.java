package com.kakaoproject.coupon.exception;

import com.kakaoproject.coupon.exception.dto.ErrorDetailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private final String DUPLICATED_EMAIL_EXCEPTION_MESSAGE = "Duplicated Email address. Please use another email address.";
    private final String INVALID_EMAIL_ADDRESS_EXCEPTION_MESSAGE = "Invalid email address. Try another one.";
    private final String JSON_HANDLING_EXCEPTION_MESSAGE = "Json handling error.";

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetailDto> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetailDto errorDetails = new ErrorDetailDto(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicatedEmailException.class)
    public final ResponseEntity<ErrorDetailDto> handleDuplicatedEmailFoundException(DuplicatedEmailException ex, WebRequest request) {
        ErrorDetailDto errorDetails = new ErrorDetailDto(new Date(), DUPLICATED_EMAIL_EXCEPTION_MESSAGE,
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidEmailException.class)
    public final ResponseEntity<ErrorDetailDto> handleDuplicatedEmailFoundException(InvalidEmailException ex, WebRequest request) {
        ErrorDetailDto errorDetails = new ErrorDetailDto(new Date(), INVALID_EMAIL_ADDRESS_EXCEPTION_MESSAGE,
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(JsonException.class)
    public final ResponseEntity<ErrorDetailDto> handleDuplicatedEmailFoundException(JsonException ex, WebRequest request) {
        ErrorDetailDto errorDetails = new ErrorDetailDto(new Date(), JSON_HANDLING_EXCEPTION_MESSAGE,
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

