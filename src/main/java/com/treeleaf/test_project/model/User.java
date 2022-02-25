package com.treeleaf.test_project.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @OneToOne(mappedBy = "user")
    private UserDetails details;

    public User() {
    }

    public User(int user_id, String name, String surname) {
        this.user_id = user_id;
        this.name = name;
        this.surname = surname;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

}
