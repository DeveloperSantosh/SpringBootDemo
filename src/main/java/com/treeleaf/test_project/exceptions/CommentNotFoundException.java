package com.treeleaf.test_project.exceptions;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(int comment_id){
        super("Sorry! comment not found with id: "+comment_id);
    }
}
