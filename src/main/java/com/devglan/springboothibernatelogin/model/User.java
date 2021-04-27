package com.devglan.springboothibernatelogin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

//annotations
//When working with JPA as our persistence layer, it’s necessary to map our API to persist our objects of choice.

//Creates toString, equals, hashCode, getters and setters methods for our class.
@Data
//Tells that our class can be represented by a table in the database, with each instance representing a row.
@Entity
@Table(name = "USERS")
public class User {

    //Specifies that this attribute is the primary key of this entity.
    @Id
    //Informs the persistence layer that the strategy used to generate the value of our primary key is by auto-increasing when a new user is created.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, length = 35, unique = true)
    private String email;
    private String username;
    @JsonIgnore
    private String password;

}
