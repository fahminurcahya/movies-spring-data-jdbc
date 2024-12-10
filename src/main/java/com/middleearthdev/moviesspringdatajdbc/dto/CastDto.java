package com.middleearthdev.moviesspringdatajdbc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CastDto {
    private String actorName;
    private String roleName;
    private Date birthDate;
    private String gender;
}
