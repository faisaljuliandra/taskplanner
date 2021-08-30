package com.faisaldev.taskplanner.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorException extends RuntimeException {
    private HttpStatus status;
    private ApiException response;

    public ErrorException(String message, HttpStatus status) {
        this.status = status;
        this.response = new ApiException("failed", message);
    }
}
