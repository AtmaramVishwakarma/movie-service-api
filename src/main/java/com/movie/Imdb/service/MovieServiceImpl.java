package com.movie.Imdb.service;

import com.movie.Imdb.entity.Movie;
import com.movie.Imdb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService
{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findMovieByName(String movieName) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieName);
        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        }
        else {
            return null;
        }
    }

    @Override

    public void deleteMovieByName(String movieName)
    {
        Optional<Movie> optionalMovie = movieRepository.findById(movieName);
        if (optionalMovie.isPresent()) {
            movieRepository.delete(optionalMovie.get());
            System.out.println("Movie deleted successfully: " + movieName);
        }
        else
        {
            System.out.println("Movie not found: " + movieName);
        }

    }
}
