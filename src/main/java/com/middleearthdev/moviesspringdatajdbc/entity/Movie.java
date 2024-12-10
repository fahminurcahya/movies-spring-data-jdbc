package com.middleearthdev.moviesspringdatajdbc.entity;

import lombok.Data;

@Data
public class Movie {
    private int id;
    private String title;
    private int durationMinutes;
    private float rating;
    private String description;
}
