import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;

@WebServlet("/WriteReview")
public class AddReviewServlet extends HttpServlet {
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		try (MovieDao dao = new MovieDao()) {
			List<Movies> list = dao.getAllMovies();
			String userId = "";
			Cookie[] arr = req.getCookies();
			if (arr != null) {
			    for (Cookie c : arr) {
			        if (c.getName().equals("userId")) {
			            userId = c.getValue();
			        }
			    }
			}

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login</title>");
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
			out.println("</head>");
			out.println("<body class=\"bg-light\">");
			out.println("<div class=\"container mt-4\">");
			out.println("<h4 class=\"text-center\">Here's the list of all movies</h4>");
			out.println("<hr class=\"my-4\">");
			out.println("<form class=\"form-inline\" method='post' action='reviews'>");
			out.println("<div class=\"form-group mx-sm-3 mb-2\">");
			out.println("<input type='text' class='form-control' name='id' placeholder='Movie ID' required>");
			out.println("</div>");
			out.println("<div class=\"form-group mx-sm-3 mb-2\">");
			out.println("<input type='text' class='form-control' name='review' placeholder='Add review here' required>");
			out.println("</div>");
			out.println("<div class=\"form-group mx-sm-3 mb-2\">");
			out.println("<input type='text' class='form-control' name='rating' placeholder='Add rating here' required>");
			out.printf("<input hidden type='text' name='userId' value='%s'/> \n", userId);
			out.println("<button type='submit' class='btn btn-primary  ml-4'>Add Review</button>");
			out.println("</div>");
			out.println("</form>");
			
			out.println("<table class='table table-bordered'>");
			
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
			

			out.println("</div>"); 
			out.println("</body>");
			out.println("</html>");

		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
