package com.movie.Imdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie
{
    @Id
    private String movieName;
    private long movieId;
    private String movieType;  // e.g., Action, Comedy, Drama
    private int releaseYear;  // Year of release

    public Movie(String movieName, long movieId, String movieType, int releaseYear) {
        this.movieName = movieName;
        this.movieId = movieId;
        this.movieType = movieType;
        this.releaseYear = releaseYear;
    }
    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
