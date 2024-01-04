import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewsDao extends Dao{
	
	public ReviewsDao() throws Exception {
		
	}
	
	public int save(Reviews r) throws Exception {
		String sql = "INSERT INTO reviews VALUES(default, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1,  r.getReviewId());
			stmt.setInt(1, r.getMovieId());
			stmt.setString(2, r.getReview());
			stmt.setInt(3, r.getRating());
			stmt.setInt(4, r.getUserId());
			Timestamp curr = new Timestamp(new Date().getTime());
			stmt.setTimestamp(5, curr);
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
	
	public Reviews getReviewById(int id) throws Exception {
		String sql = "select * from reviews where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 Reviews review = new Reviews();
					 review.setReviewId(rs.getInt("id"));
					 review.setMovieId(rs.getInt("movie_id"));
					 review.setReview(rs.getString("review"));
					 review.setRating(rs.getInt("rating"));
					 review.setUserId(rs.getInt("user_id"));
					 Timestamp tmp = rs.getTimestamp("modified");
					 review.setModified(new Date(tmp.getTime()));
					 return review;
				 }
			 }
		}
		return null;
	}
	
//	select r.* from reviews r join shares s on r.review_id = s.review_id and s.user_id = 4
	
	public List<Reviews> getAllReviews() throws Exception {
		String sql = "select * from reviews";
		List<Reviews> reviewsList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 Reviews review = new Reviews();
					 review.setReviewId(rs.getInt("id"));
					 review.setMovieId(rs.getInt("movie_id"));
					 review.setReview(rs.getString("review"));
					 review.setRating(rs.getInt("rating"));
					 review.setUserId(rs.getInt("user_id"));
					 Timestamp tmp = rs.getTimestamp("modified");
					 review.setModified(new Date(tmp.getTime()));
					 reviewsList.add(review);
				 }
				 return reviewsList;
			 }
		} //stmt.close();
	}
	
	public List<Reviews> getAllReviewsSharedWithMe(Integer id) throws Exception {
		String sql = "select r.* from reviews r join shares s on r.id = s.review_id and s.user_id = ?";
		List<Reviews> reviewsList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 Reviews review = new Reviews();
					 review.setReviewId(rs.getInt("id"));
					 review.setMovieId(rs.getInt("movie_id"));
					 review.setReview(rs.getString("review"));
					 review.setRating(rs.getInt("rating"));
					 review.setUserId(rs.getInt("user_id"));
					 Timestamp tmp = rs.getTimestamp("modified");
					 review.setModified(new Date(tmp.getTime()));
					 reviewsList.add(review);
				 }
				 return reviewsList;
			 }
		} //stmt.close();
	}
	
	public List<Reviews> getAllReviewsByUserId(Integer id) throws Exception {
		String sql = "select * from reviews where user_id = ?";
		List<Reviews> reviewsList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 Reviews review = new Reviews();
					 review.setReviewId(rs.getInt("id"));
					 review.setMovieId(rs.getInt("movie_id"));
					 review.setReview(rs.getString("review"));
					 review.setRating(rs.getInt("rating"));
					 review.setUserId(rs.getInt("user_id"));
					 Timestamp tmp = rs.getTimestamp("modified");
					 review.setModified(new Date(tmp.getTime()));
					 reviewsList.add(review);
				 }
				 return reviewsList;
			 }
		} //stmt.close();
	}
	
	public int editReview(Reviews r) throws Exception {
		String sql = "update reviews set review = ?, rating = ?, user_id = ? , modified = ? where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, r.getReview());
			stmt.setInt(2,  r.getRating());
			stmt.setInt(3,  r.getUserId());
			stmt.setTimestamp(4, new Timestamp(new Date().getTime()));
			stmt.setInt(5, r.getReviewId());
			int count = stmt.executeUpdate();
			return count;
		}
	
	}
	
	
	
	public int delete(int reviewId) throws Exception {
		String sql = "delete from reviews where id = ?";
		try (PreparedStatement stmt1 = con.prepareStatement(sql)) {
			stmt1.setInt(1, reviewId);
			stmt1.executeUpdate();
		}
		return 0;
	}
}
