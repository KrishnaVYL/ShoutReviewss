package com.gfg.shoutreviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfg.shoutreviews.entity.Genre;
import com.gfg.shoutreviews.entity.Movie;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie,Long> {
	@Query(value="select * from movie_table where title=?",nativeQuery = true)
	Movie findByTitle(String title);
	
	List<Movie> findByGenre(Genre genre);
}
