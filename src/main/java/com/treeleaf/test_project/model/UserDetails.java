package com.treeleaf.test_project.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String location;
    private String number;
    private int age;
    private String gender;

}