package com.gfg.shoutreviews.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gfg.shoutreviews.entity.Movie;
import com.gfg.shoutreviews.entity.Review;
import com.gfg.shoutreviews.repository.MovieRepository;
import com.gfg.shoutreviews.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public void addReview(Review review)
	{
		Movie movie =movieRepository.findById(review.getMovie().getId()).orElse(null);
		reviewRepository.save(review);
		if(movie!=null)
		{
			Double average=reviewRepository.getReviewAverage(movie.getId());
			movie.setRating(average);
			movieRepository.save(movie);
		}
		
	}
	
	public Review getReviewById(Long reviewId)
	{
		return reviewRepository.findById(reviewId).orElse(null);
	}

}
