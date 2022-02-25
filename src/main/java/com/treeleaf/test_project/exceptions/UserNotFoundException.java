package com.treeleaf.test_project.exceptions;

import com.treeleaf.test_project.controller.UserController;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int user_id){
        super("Sorry, user not found with id: "+user_id);
    }
}
