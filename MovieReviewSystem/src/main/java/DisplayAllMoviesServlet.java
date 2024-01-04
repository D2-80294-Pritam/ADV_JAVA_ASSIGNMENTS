import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/DisplayAllMovies")
public class DisplayAllMoviesServlet extends HttpServlet{
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try (MovieDao dao = new MovieDao()) {
			List<Movies> list = dao.getAllMovies();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Movies</title>");
			out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
			out.println("</head>");
			out.println("<body class='container mt-4'>");
			out.println("<h4>Here's the list of all movies</h4>");
			out.println("<hr class='mb-4'/>");

			// Table for displaying movies
			out.println("<table class='table table-bordered'>");
			out.println("<thead class='thead-dark'>");
			out.println("<tr>");
			out.println("<th scope='col'>Movie ID</th>");
			out.println("<th scope='col'>Title</th>");
			out.println("<th scope='col'>Release Date</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			for (Movies movie : list) {
			    out.println("<tr>");
			    out.printf("<td>%d</td>", movie.getMovieId());
			    out.printf("<td>%s</td>", movie.getTitle());
			    out.printf("<td>%tF</td>", movie.getReleaseDate()); 
			    out.println("</tr>");
			}

			out.println("</tbody>");
			out.println("</table>");

			out.println("</body>");
			out.println("</html>");


		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
