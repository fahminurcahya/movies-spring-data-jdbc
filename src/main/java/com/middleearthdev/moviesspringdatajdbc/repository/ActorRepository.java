package com.middleearthdev.moviesspringdatajdbc.repository;


import com.middleearthdev.moviesspringdatajdbc.entity.Actor;
import com.middleearthdev.moviesspringdatajdbc.entity.Cast;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer>{

    @Query(" SELECT mc.role_name, a.name, a.birth_date, a.gender " +
            "FROM movie_cast mc " +
            "JOIN actors a ON a.id = mc.actor_id " +
            "WHERE mc.movie_id = :movieId;")
    List<Cast> getAllName(@Param("movieId") int movieId);

}
