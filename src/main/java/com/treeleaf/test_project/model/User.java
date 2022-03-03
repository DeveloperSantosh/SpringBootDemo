package com.treeleaf.test_project.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @OneToOne(targetEntity = UserDetails.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserDetails details;

}
