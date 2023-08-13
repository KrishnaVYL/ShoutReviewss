package com.gfg.shoutreviews.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.gfg.shoutreviews.entity.Genre;
import com.gfg.shoutreviews.entity.Movie;
import com.gfg.shoutreviews.repository.MovieRepository;
import com.gfg.shoutreviews.response.MovieResponse;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public MovieResponse findMovie(String title)
	{
		//Write code to fetch from repo
		//handle movie not exist scenario
		//caching logic 
		//exception handling
		Movie movie=movieRepository.findByTitle(title);
		
		if(movie!=null)
		{
			return movie.toMovieResponse();
		}
		return null;
	}
	
	public List<MovieResponse> findMoviesByGenre(String genre)
	{
		if(Arrays.stream(Genre.values()).noneMatch(g->g.toString().equals(genre)))
		{
			return new ArrayList<>();
		}
		List<Movie> movieList=movieRepository.findByGenre(Genre.valueOf(genre));
		if(!CollectionUtils.isEmpty(movieList))
		{
			List<MovieResponse> movieResponseList=
			movieList.stream().sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).map
			(m->m.toMovieResponse()).collect(Collectors.toList());
			
			if(movieResponseList.size()>5)
			{
				return movieResponseList.subList(0,4);
			}
			return movieResponseList;
			
		}
		return new ArrayList<>();
	}

}
