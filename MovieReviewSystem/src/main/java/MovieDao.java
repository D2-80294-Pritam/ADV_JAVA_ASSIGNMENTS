import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class MovieDao extends Dao{
	
	public MovieDao() throws Exception{
		
	}
	
	public List<Movies> getAllMovies() throws Exception {
		String sql = "select * from movies";
		List<Movies> movieList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			 try (ResultSet rs = stmt.executeQuery()) {
				 while (rs.next()) {
					 Movies movie = new Movies();
					 movie.setMovieId(rs.getInt("id"));
					 movie.setTitle(rs.getString("title"));
					 movie.setReleaseDate(rs.getDate("rel_date"));
					 movieList.add(movie);
				 }
				 return movieList;
			 }
		} //stmt.close();
	}
}
