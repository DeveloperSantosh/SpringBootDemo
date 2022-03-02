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
    private String name;
    @NotNull
    private String surname;
    @OneToOne(targetEntity = UserDetails.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserDetails details;

}
