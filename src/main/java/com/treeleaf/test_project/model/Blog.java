package com.treeleaf.test_project.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @NotNull
    private String title;
    @NotNull
    @Lob
    private String content;
    @NotNull
    private String createdAt;

    @ManyToMany(targetEntity = Comment.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "blog_comment",
            joinColumns = { @JoinColumn(name = "title") },
            inverseJoinColumns = { @JoinColumn(name = "comment_id") })
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User author;


    public Blog() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        createdAt = dateTime.format(myFormatObj);
    }

    public Blog(String title, String content) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        createdAt = dateTime.format(myFormatObj);
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
