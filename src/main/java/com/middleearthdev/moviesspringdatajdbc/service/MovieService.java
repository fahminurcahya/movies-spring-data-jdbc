package com.middleearthdev.moviesspringdatajdbc.service;

import com.middleearthdev.moviesspringdatajdbc.dto.CastDto;
import com.middleearthdev.moviesspringdatajdbc.dto.GetMoviesResponse;
import com.middleearthdev.moviesspringdatajdbc.entity.Cast;
import com.middleearthdev.moviesspringdatajdbc.entity.Movie;
import com.middleearthdev.moviesspringdatajdbc.repository.ActorRepository;
import com.middleearthdev.moviesspringdatajdbc.repository.MovieCastRepository;
import com.middleearthdev.moviesspringdatajdbc.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieCastRepository movieCastRepository;

    @Autowired
    ActorRepository actorRepository;

    public ResponseEntity<?> getAllMovies(){
        //get all movies

        List<Movie> movies = movieRepository.fetchMovies();
        List<GetMoviesResponse> getMoviesResponses = new ArrayList<>();
        for (Movie movie : movies) {
            GetMoviesResponse moviesResponse = new GetMoviesResponse();
            moviesResponse.setId(movie.getId());
            moviesResponse.setTitle(movie.getTitle());
            moviesResponse.setDescription(movie.getDescription());
            moviesResponse.setRating(movie.getRating());
            moviesResponse.setDurationMinutes(movie.getDurationMinutes());
            List<Cast> castByMovie = movieCastRepository.getCastByMovie(movie.getId());
            List<CastDto> listCast = castByMovie.stream()
                    .map(cast -> {
                        CastDto castDto = new CastDto();
                        castDto.setActorName(cast.getName());
                        castDto.setGender(cast.getGender());
                        castDto.setBirthDate(cast.getBirthDate());
                        castDto.setRoleName(cast.getRoleName());
                        return castDto;
                    }).toList();
            moviesResponse.setCast(listCast);
            getMoviesResponses.add(moviesResponse);
        }
        return ResponseEntity.ok(getMoviesResponses);

    }

    public  ResponseEntity<?> getAllActors(int id){
        List<Cast> allName = actorRepository.getAllName(id);
        return ResponseEntity.ok(allName);
    }
}
