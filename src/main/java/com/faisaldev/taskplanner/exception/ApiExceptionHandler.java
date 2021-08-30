package com.faisaldev.taskplanner.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ErrorException.class})
    public ResponseEntity<Object> handleErrorException(ErrorException exception) {
        return new ResponseEntity<>(exception.getResponse(), exception.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        return new ResponseEntity<>(
                new ApiException(
                        "failed",
                        "Method "+ exception.getMethod()+" tidak tersedia!"
                ),
                status
        );
    }

//    @ExceptionHandler({ Exception.class })
//    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
//        ErrorException apiError = new ErrorException(
//                ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        return new ResponseEntity<Object>(
//                apiError, apiError.getStatus());
//    }
}
