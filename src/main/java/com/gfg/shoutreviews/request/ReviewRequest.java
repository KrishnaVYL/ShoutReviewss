package com.gfg.shoutreviews.request;
import com.gfg.shoutreviews.entity.Movie;
import com.gfg.shoutreviews.entity.Review;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequest {
	
	private String movieReview;
	private double rating;
	private Long movieId;
	
	public Review toReview() {
		return Review.builder()
				.movieReview(movieReview)
				.rating(rating)
				.movie(Movie.builder()
				       .id(movieId)
				       .build())
				.build();

	}

}
