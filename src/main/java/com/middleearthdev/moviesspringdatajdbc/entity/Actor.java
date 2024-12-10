package com.middleearthdev.moviesspringdatajdbc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Actor {
    private String name;
    private Date birthDate;
    private String gender;
}
