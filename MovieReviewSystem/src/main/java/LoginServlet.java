import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet   {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		
		User user = null;
		boolean success = false;
		
		try (UserDao dao = new UserDao()) {
			User user1 = dao.findByEmail(email);
			if (user1 != null) {
				if (password.equals(user1.getPassword())) {
					user = user1;
					success = true;
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		if(success) {
			Cookie c = new Cookie("userId", user.getId().toString());
			resp.addCookie(c);
			resp.sendRedirect("menu");
		} 
		else {
			out.println("Invalid email or password. <br/><br/>");
			out.println("<a href='index.html'>Login Again</a>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}