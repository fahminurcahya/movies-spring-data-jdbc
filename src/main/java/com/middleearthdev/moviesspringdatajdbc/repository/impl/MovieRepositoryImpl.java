package com.middleearthdev.moviesspringdatajdbc.repository.impl;

import com.middleearthdev.moviesspringdatajdbc.entity.Movie;
import com.middleearthdev.moviesspringdatajdbc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.util.List;


@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Movie> fetchMovies() {
        String sql = """
                SELECT * FROM movies;
                """;
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setDescription(rs.getString("description"));
            movie.setRating(rs.getFloat("rating"));
            movie.setDurationMinutes(rs.getInt("duration_minutes"));
            return movie;
        });
    }
}
