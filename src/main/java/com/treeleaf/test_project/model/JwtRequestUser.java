package com.treeleaf.test_project.model;

import java.io.Serializable;

public class JwtRequestUser implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

    public JwtRequestUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JwtRequestUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
