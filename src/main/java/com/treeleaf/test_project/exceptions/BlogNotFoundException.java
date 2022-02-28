package com.treeleaf.test_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String title){
        super("Sorry! Blog not found with title: "+title);
    }
}
