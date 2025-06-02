package com.movie.Imdb.controller;

import com.movie.Imdb.entity.Movie;
import com.movie.Imdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")    //this is base URL for all movie-related endpoints
public class MovieController
{
    @Autowired
    private MovieService movieService;



    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie( @RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName) {
        Movie movie = movieService.findMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }

    @PutMapping("/{movieName}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieName, @RequestBody Movie movie) {
        Movie existingMovie = movieService.findMovieByName(movieName);
        if (existingMovie != null) {
            movie.setMovieName(movieName); // Ensure the name remains the same
            Movie updatedMovie = movieService.saveMovie(movie);
            return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{movieName}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieName) {
        movieService.deleteMovieByName(movieName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
