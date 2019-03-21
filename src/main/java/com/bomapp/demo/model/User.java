package com.bomapp.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String login;

    @Column
    private String name;

    @Column(name = "department_id")
    private int departmentId;
}
