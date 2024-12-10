package com.middleearthdev.moviesspringdatajdbc.repository;

import com.middleearthdev.moviesspringdatajdbc.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> fetchMovies();
}
