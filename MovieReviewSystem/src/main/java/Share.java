
public class Share {
	
	private Integer reviewId;
	private Integer userId;
	
	public Share () {
		
	}
	
	
	
	public Share(Integer reviewId, Integer userId) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Share [reviewId=" + reviewId + ", userId=" + userId + "]";
	}



	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
