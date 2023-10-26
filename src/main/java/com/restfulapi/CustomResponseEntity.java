package com.restfulapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponseEntity {

    public static ResponseEntity<String> notFound(String message) {
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<String> ok(String message) {
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}