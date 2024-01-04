import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/deletereview")
public class DeleteReviewServlet extends HttpServlet {

	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		processRequest(req, resp);
	}	
	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		processRequest(req, resp);
	}	
	
	protected void processRequest(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		String reviewId = req.getParameter("rId");
		int id = Integer.parseInt(reviewId);
		int cnt = 0;
//		System.out.println(reviewId);
		try(ReviewsDao dao = new ReviewsDao()) {
			dao.delete(id);
//			System.out.println("Just Checking");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

//		req.setAttribute("message", "Candidates Deleted: " + cnt);
		resp.sendRedirect("reviews?type=my");
//		RequestDispatcher rd = req.getRequestDispatcher("reviews");
//		rd.forward(req, resp);
	}
	
}
