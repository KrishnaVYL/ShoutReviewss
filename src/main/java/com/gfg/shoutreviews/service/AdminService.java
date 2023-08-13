package com.gfg.shoutreviews.service;

import com.gfg.shoutreviews.entity.Movie;
import com.gfg.shoutreviews.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository)
    {
        this.movieRepository=movieRepository;
    }

    public Movie addMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }
}
