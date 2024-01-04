import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;

public class ShareDao extends Dao {
	
	public ShareDao() throws Exception {
		
	}
	
	public int save(Share s) throws Exception {
		String sql = "INSERT INTO shares VALUES(?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1,  s.getReviewId());
			stmt.setInt(2, s.getUserId());
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
}
