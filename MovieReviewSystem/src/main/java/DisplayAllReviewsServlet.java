import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/DisplayAllReviews")
public class DisplayAllReviewsServlet extends HttpServlet {
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		String review = req.getParameter("review");
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		
	}
}
