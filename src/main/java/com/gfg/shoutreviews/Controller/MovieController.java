package com.gfg.shoutreviews.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.shoutreviews.entity.Movie;
import com.gfg.shoutreviews.response.MovieResponse;
import com.gfg.shoutreviews.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	 @Autowired
	 MovieService movieService;



	 @RequestMapping("/test")
	 public String test()
	 {
		 return "Test API Works";
	 }
	 
	 @GetMapping("/title")
	 public MovieResponse findMovie(@RequestParam String title)
	 {
		 return movieService.findMovie(title);
	 }
	 
	 @GetMapping("/genre")
	 public List<MovieResponse> findMoviesByGenre(@RequestParam String genre)
	 {
		 return movieService.findMoviesByGenre(genre);
	 }

}
