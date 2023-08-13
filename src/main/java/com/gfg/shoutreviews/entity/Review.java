package com.gfg.shoutreviews.entity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gfg.shoutreviews.response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name= "review_table")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder //Lombok @Builder needs a proper constructor for this class
public class Review {
    @Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String movieReview;
	private double rating; //rating dedicated to each review.
	@ManyToOne
	@JoinColumn(name="movie_id",nullable=false)
	@JsonIgnore	
	private Movie movie;//it will add foreign key in mySQL Table with <Table_Name>_<ID_Name>-->
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	public static  ReviewResponse toReviewResponse(Review review)
	{
		return ReviewResponse.builder().reviews(review.movieReview).rating(review.rating).build();
	}
	
	public static List<ReviewResponse> toReviewResponse(List<Review> reviewList)
	{
		if(Objects.isNull(reviewList))
			return new ArrayList<>();
		else
			return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
	}

}
