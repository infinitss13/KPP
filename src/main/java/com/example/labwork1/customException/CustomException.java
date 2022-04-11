package com.example.labwork1.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data")
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }

}

