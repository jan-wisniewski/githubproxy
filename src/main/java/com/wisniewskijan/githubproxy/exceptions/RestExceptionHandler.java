package com.wisniewskijan.githubproxy.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public static ResponseEntity<Object> build(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getCode());
    }

    @ExceptionHandler(BadHeaderException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(BadHeaderException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "AAAAA");
        return build(errorResponse);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpClientErrorException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "User cannot be found. ");
        return build(errorResponse);
    }

}
