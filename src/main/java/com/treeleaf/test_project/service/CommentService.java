package com.treeleaf.test_project.service;

import com.treeleaf.test_project.model.Comment;

import java.util.List;

public interface CommentService {
    public Comment saveComment(Comment comment);
    public Comment updateComment(Comment comment, Integer commentId);
    public void deleteCommentById(Integer commentId);
    public Comment getCommentById(Integer commentId);
    public List<Comment> getAllComment();
}
