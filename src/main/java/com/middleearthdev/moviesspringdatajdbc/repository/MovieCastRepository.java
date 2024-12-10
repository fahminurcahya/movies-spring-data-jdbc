package com.middleearthdev.moviesspringdatajdbc.repository;

import com.middleearthdev.moviesspringdatajdbc.entity.Cast;

import java.util.List;

public interface MovieCastRepository {
    List<Cast> getCastByMovie(int id);
}
