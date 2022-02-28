package com.treeleaf.test_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDetailsNotFoundException extends RuntimeException {

    public UserDetailsNotFoundException(Integer userDetailsId){
        super("User details not found for ID: "+ userDetailsId);
    }
}
