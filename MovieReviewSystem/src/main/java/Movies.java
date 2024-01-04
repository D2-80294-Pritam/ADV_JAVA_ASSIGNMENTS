import java.util.Date;

public class Movies {
	
	private Integer movieId;
	private String title;
	private Date releaseDate;
	
	
	public Movies() {
		
	}
	
	public Movies(Integer movieId, String title, Date releaseDate) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.releaseDate = releaseDate;
	}
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}
	
	
}
