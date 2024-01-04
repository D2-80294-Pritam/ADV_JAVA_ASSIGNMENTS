import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/menu")
public class ApplicationMenu extends HttpServlet{
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		resp.setContentType("text/html");
		String[] arr = {"LogOut", "EditProfile", "ChangePassword", "WriteReview", "DisplayAllMovies"};
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Menu</title>");
		out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body class='container mt-4'>");
		out.println("<h4>Here's the list of operations you can perform</h4>");
		out.println("<hr class='mb-4'/>");

		for (String s : arr) {
		    out.printf("<a class='btn btn-primary mb-2' href='%s'>%s</a><br />\n", s, s);
		}
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=my'>Edit Reviews</a><br />\n");
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=all'>All Reviews</a><br />\n");
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=my'>My Reviews</a><br />\n");
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=shared'>Shared Review</a><br />\n");
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=my'>Delete Review</a><br />\n");
		out.printf("<a class='btn btn-primary mb-2' href='reviews?type=my'>Share Review</a><br />\n");

		out.println("</body>");
		out.println("</html>");

	}
}
