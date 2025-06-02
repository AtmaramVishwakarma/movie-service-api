package com.movie.Imdb.service;

import com.movie.Imdb.entity.Movie;

import java.util.List;

public interface MovieService
{
    // Method to save a movie
    Movie saveMovie(Movie movie);

    // Method to find all movies
    List<Movie> findAllMovies();

    // Method to find a movie by its name
    Movie findMovieByName(String movieName);

    // Method to delete a movie by its name
    void deleteMovieByName(String movieName);
}
