package com.middleearthdev.moviesspringdatajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootApplication
public class MoviesSpringDataJdbcApplication {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(MoviesSpringDataJdbcApplication.class, args);
    }

}
