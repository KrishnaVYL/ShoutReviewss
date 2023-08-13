package com.gfg.shoutreviews.entity;

import java.io.Serializable;
import java.util.List;
import com.gfg.shoutreviews.response.MovieResponse;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class 	Movie implements Serializable{
	@Id
	@Column(name="id", nullable =false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private double rating; //Single entity which is avergae rating of all reviews for a movie
	@OneToMany(mappedBy="movie")
	private List<Review> reviews;
	public MovieResponse toMovieResponse()
	{
		return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).
				reviews(Review.toReviewResponse(this.reviews)).build();
	}
	
}
