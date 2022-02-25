package com.treeleaf.test_project.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int user_id){
        super("Sorry, user not found with id: "+user_id);
    }
}
