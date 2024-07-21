package ru.diasoft.edu.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.diasoft.edu.exception.NoSuchPersonException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchPersonException.class)
    public ResponseEntity<String> handleNoSuchPersonException(NoSuchPersonException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
