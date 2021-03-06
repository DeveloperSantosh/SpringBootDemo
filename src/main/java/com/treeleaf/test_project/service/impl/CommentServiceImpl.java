package com.treeleaf.test_project.service.impl;

import com.treeleaf.test_project.exceptions.CommentNotFoundException;
import com.treeleaf.test_project.model.Comment;
import com.treeleaf.test_project.repository.CommentRepository;
import com.treeleaf.test_project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @CachePut(value = "CommentCache",key = "#commentId")
    public Comment updateComment(Comment comment, Integer commentId) {
        Comment oldComment = commentRepository.findById(commentId).
                orElseThrow(()-> new CommentNotFoundException(commentId));
        oldComment.setComment(comment.getComment());
        oldComment.setComment_id(comment.getComment_id());
        oldComment.setCreatedAt(comment.getCreatedAt());
        return commentRepository.save(oldComment);
    }

    @Override
    @CacheEvict(value = "CommentCache", key = "#commentId")
    public void deleteCommentById(Integer commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new CommentNotFoundException(commentId));
        commentRepository.delete(comment);
    }

    @Override
    @Cacheable(value = "CommentCache", key = "#commentId")
    public Comment getCommentById(Integer commentId) {
        return commentRepository.findById(commentId).
                orElseThrow(()-> new CommentNotFoundException(commentId));
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
