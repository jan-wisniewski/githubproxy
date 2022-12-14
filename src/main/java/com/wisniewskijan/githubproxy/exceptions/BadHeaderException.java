package com.wisniewskijan.githubproxy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadHeaderException extends RuntimeException {
    public BadHeaderException(String message) {
        super(message);
    }
}
