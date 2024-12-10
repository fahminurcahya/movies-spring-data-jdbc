package com.middleearthdev.moviesspringdatajdbc.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetMoviesResponse {
    private int id;
    private String title;
    private int durationMinutes;
    private float rating;
    private String description;
    private List<CastDto> cast;
}
