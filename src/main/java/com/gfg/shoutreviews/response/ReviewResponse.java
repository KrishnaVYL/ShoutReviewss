package com.gfg.shoutreviews.response;

import lombok.*;


@Builder
@Data
public class ReviewResponse {
	
	private String reviews;
	private Double rating;

}
