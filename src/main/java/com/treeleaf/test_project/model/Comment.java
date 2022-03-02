package com.treeleaf.test_project.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comment_id;
    @NotNull
    private String comment;
    @NotNull
    private String createdAt;

    public Comment() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        createdAt = dateTime.format(myFormatObj);
    }

    public Comment(int comment_id, String comment) {
        this.comment_id = comment_id;
        this.comment = comment;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        createdAt = dateTime.format(myFormatObj);
    }

}
