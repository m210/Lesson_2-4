package com.example.lesson_24;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeStoreException extends RuntimeException {

    public EmployeeStoreException(String message) {
        super(message);
    }

}
