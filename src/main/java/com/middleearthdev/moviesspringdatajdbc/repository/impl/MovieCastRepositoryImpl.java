package com.middleearthdev.moviesspringdatajdbc.repository.impl;

import com.middleearthdev.moviesspringdatajdbc.entity.Cast;
import com.middleearthdev.moviesspringdatajdbc.repository.MovieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieCastRepositoryImpl implements MovieCastRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Cast> getCastByMovie(int id) {
        String sql = """
                   SELECT mc.role_name, a.name, a.birth_date, a.gender
                   FROM movie_cast mc
                   JOIN actors a ON a.id = mc.actor_id
                   WHERE mc.movie_id = :movieId;
                """;
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("movieId", id);

        return namedParameterJdbcTemplate.query(sql,params,(rs, rowNum) -> {
            Cast cast = new Cast();
            cast.setRoleName(rs.getString("role_name"));
            cast.setName(rs.getString("name"));
            cast.setBirthDate(rs.getDate("birth_date"));
            cast.setGender(rs.getString("gender"));
            return cast;
        });
    }
}
