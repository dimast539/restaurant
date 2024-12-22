package com.vst.restaurant.handlers;

import com.vst.restaurant.exceptions.StaffNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(StaffNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String StaffNotFoundException(StaffNotFoundException staffNotFoundException){
        return staffNotFoundException.getMessage();
    }
}
