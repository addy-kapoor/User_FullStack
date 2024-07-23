package com.codeWithAditi.fullstack_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String>  userNotFoundException(UserNotFoundException e){
        HashMap<String, String> errorMap = new HashMap<>();
        errorMap.put("error message", e.getMessage());
        return errorMap;
    }
}
