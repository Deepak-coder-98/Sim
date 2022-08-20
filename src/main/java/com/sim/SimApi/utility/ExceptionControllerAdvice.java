package com.sim.SimApi.utility;

import com.sim.SimApi.exception.MobileNoException;
import com.sim.SimApi.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {

        ErrorInfo error = new ErrorInfo(environment.getProperty("General.EXCEPTION_MESSAGE"), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MobileNoException.class)
    public ResponseEntity<ErrorInfo> mobileNoExceptionHandler(MobileNoException exception) {

        ErrorInfo error = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorInfo> recordNotFoundExceptionHandler(RecordNotFoundException exception) {

        ErrorInfo error = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
