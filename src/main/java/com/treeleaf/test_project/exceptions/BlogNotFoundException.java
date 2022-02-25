package com.treeleaf.test_project.exceptions;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String title){
        super("Sorry! Blog not found with title: "+title);
    }
}
