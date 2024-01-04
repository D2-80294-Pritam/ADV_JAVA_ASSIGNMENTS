import java.util.Date;

public class Reviews {
	
	private Integer reviewId;
	private Integer movieId;
	private String review;
	private Integer rating;
	private Integer userId;
	private Date modified;
	
	public Reviews() {
		
	}
	
	public Reviews(Integer reviewId, Integer movieId, String review, Integer rating, Integer userId, Date modified) {
		super();
		this.reviewId = reviewId;
		this.movieId = movieId;
		this.review = review;
		this.rating = rating;
		this.userId = userId;
		this.modified = modified;
	}
	
	public void editReview() {
		
	}
	
	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", movieId=" + movieId + ", review=" + review + ", rating=" + rating
				+ ", userId=" + userId + ", modified=" + modified + "]";
	}

	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	
	

}
