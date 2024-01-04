
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao extends Dao {
	
	public UserDao() throws Exception {
	}
	
	public int save(User u) throws Exception {
		String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1,  u.getId());
			stmt.setString(2, u.getFirstName());
			stmt.setString(3, u.getLastName());
			stmt.setString(4, u.getEmail());
			stmt.setString(5, u.getPassword());
			stmt.setString(6, u.getMobile());
			stmt.setDate(7, DateUtil.utilToSqlDate(u.getBirthdate()));
			int count = stmt.executeUpdate();
			return count;
		} //stmt.close();
	}
	
	public int changePassword(User u) throws Exception {
		String sql = "update users set password = ? where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getPassword());
			stmt.setInt(2,  u.getId());
			int count = stmt.executeUpdate();
			return count;
		}
	}
	
	public List<User> getAllUsers() throws Exception {
		String sql = "select * from users";
		List<User> reviewsList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 User review = new User();
					 review.setId(rs.getInt("id"));
					 review.setFirstName(rs.getString("first_name"));
					 review.setLastName(rs.getString("last_name"));
					 review.setEmail(rs.getString("email"));
					 review.setPassword(rs.getString("password"));
					 review.setMobile(rs.getString("mobile"));
					 review.setBirthdate(rs.getDate("birth"));
					 reviewsList.add(review);
				 }
				 return reviewsList;
			 }
		} //stmt.close();
	}
	
	public int editProfile(User u) throws Exception {
		String sql = "update users set first_name = ?, last_name = ?, email = ? , mobile = ?, birthdate = ? where id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, u.getFirstName());
			stmt.setString(2,  u.getLastName());
			stmt.setString(3,  u.getEmail());
			stmt.setString(4,  u.getMobile());
			stmt.setDate(5, DateUtil.utilToSqlDate(u.getBirthdate()));
			stmt.setInt(6, u.getId());
			int count = stmt.executeUpdate();
			return count;
		}
	}
	
	public User findByEmail(String email) throws Exception {
		String sql = "SELECT * FROM users WHERE email=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, email);
			try(ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String uEmail = rs.getString("email");
					String password = rs.getString("password");
					String mobileNo = rs.getString("mobile");
					Date uBirthDate = DateUtil.sqlToUtilDate(rs.getDate("birth"));
					return new User(id, fname, lname, uEmail, password, mobileNo, uBirthDate);
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}

}



