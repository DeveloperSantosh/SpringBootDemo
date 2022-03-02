package com.treeleaf.test_project.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "blog")
public class Blog implements Serializable {

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
            joinColumns = { @JoinColumn(name = "blog_title") },
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

}
