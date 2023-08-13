package com.gfg.shoutreviews.response;

import java.util.List;

import com.gfg.shoutreviews.entity.Genre;

import lombok.*;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
	
	private String title;
	private Genre genre;
	private Double rating;
	private List<ReviewResponse> reviews;

}
