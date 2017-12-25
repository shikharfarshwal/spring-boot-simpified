package com.example.controller.advice;

import com.example.domain.ErrorResponse;
import com.example.excpetion.RequestBodyHasInvalidData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Shikhar on 25-12-2017.
 */
@ControllerAdvice
public class DemoControllerAdvice {
    @ExceptionHandler(RequestBodyHasInvalidData.class)
    public ResponseEntity<ErrorResponse> handleValidationException(RequestBodyHasInvalidData requestBodyHasInvalidData) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        errorResponse.setMessage(requestBodyHasInvalidData.getErrors().getFieldError().getDefaultMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_ACCEPTABLE);
    }
}
