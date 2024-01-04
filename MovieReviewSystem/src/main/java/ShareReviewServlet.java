import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sharereview")
public class ShareReviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] arr = req.getCookies();
		String userId = "";
		String reviewId = req.getParameter("rId");
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("userId")) {
					userId = c.getValue();
				}
			}
		}
		List<User> list = null;
		int curUserId = Integer.parseInt(userId);
		try (UserDao dao = new UserDao()) {
			list = dao.getAllUsers();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>User List</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body class=\"bg-light\">");
		out.println("<div class=\"container mt-4\">");
		out.println("<h4 class=\"text-center\">User List</h4>");
		out.println("<hr class=\"my-4\">");

	
		out.println("<table class=\"table table-bordered\">");
		out.println("<thead class=\"thead-dark\">");
		out.println("<tr>");
		out.println("<th scope=\"col\">ID</th>");
		out.println("<th scope=\"col\">First Name</th>");
		out.println("<th scope=\"col\">Last Name</th>");
		out.println("<th scope=\"col\">Email</th>");
		out.println("<th scope=\"col\">Mobile</th>");
		out.println("<th scope=\"col\">Birthdate</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for (User user : list) {
		    if (user.getId() != curUserId) {
		    	out.println("<tr>");
			    out.printf("<th scope=\"row\">%d</th>", user.getId());
			    out.printf("<td>%s</td>", user.getFirstName());
			    out.printf("<td>%s</td>", user.getLastName());
			    out.printf("<td>%s</td>", user.getEmail());
			    out.printf("<td>%s</td>", user.getMobile());
			    out.printf("<td>%tF</td>", user.getBirthdate()); // Format as YYYY-MM-DD
			    out.println("</tr>");
		    }
		}

		out.println("</tbody>");
		out.println("</table>");
		
		out.println("<form method='post' action='sharereview'>");
		out.println("<div class=\"form-group\">");
		out.println("<input type=\"text\" class=\"form-control\" id=\"shareIdInput\" name=\"shareId\" placeholder=\"Enter the Id of the user\" required>");
		out.printf("<input hidden type=\"text\" name=\"reviewId\" value=\"%s\">\n", reviewId);
		out.println("<button type='submit' class='btn btn-primary mt-3'>Share</button>");
		out.println("</div>");
		out.println("</form>");

		out.println("</div>"); 
		out.println("</body>");
		out.println("</html>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sharedUserId = req.getParameter("shareId");
		String reviewId = req.getParameter("reviewId");
		
		
		try (ShareDao dao = new ShareDao()) {
			dao.save(new Share(Integer.parseInt(reviewId), Integer.parseInt(sharedUserId)));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		resp.sendRedirect("reviews?type=my");
	}
	
	
	
}
