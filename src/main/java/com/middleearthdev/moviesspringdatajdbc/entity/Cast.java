package com.middleearthdev.moviesspringdatajdbc.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

@Data
public class Cast {
    private String name;
    private String roleName;
    private Date birthDate;
    private String gender;
}
