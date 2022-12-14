package com.wisniewskijan.githubproxy.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    private HttpStatus code;
    private String message;
}
