package com.gfg.shoutreviews.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gfg.shoutreviews.entity.Review;
import com.gfg.shoutreviews.request.ReviewRequest;
import com.gfg.shoutreviews.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@RequestMapping("/test")
	public String test()
	{
		return "Test API Works";
	}
	@PostMapping("/add")
	public void addReview(@RequestBody ReviewRequest reviewRequest)
	{
		reviewService.addReview(reviewRequest.toReview());
	}
	
	@GetMapping("/find")
	public Review getReview(@RequestParam Long reviewId)
	{
		return reviewService.getReviewById(reviewId); 
	}

}
