import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editreview")
public class EditReviewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewId = req.getParameter("rId");
		int id = Integer.parseInt(reviewId);
		
		Reviews review = null;
		
		try(ReviewsDao dao = new ReviewsDao()) {
			System.out.println(id);
			review = dao.getReviewById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
	
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Review</title>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body class='container'>");

		out.println("<h4 class='mb-4'>Edit Review</h4>");
		out.println("<hr/>");

		out.println("<form method='post' action='editreview'>");

		// Hidden input field for Movie ID
		out.printf("<input type='hidden' name='reviewId' value='%d'/>\n", review.getReviewId());
		out.printf("<input type='hidden' name='movieId' value='%d'/>\n", review.getMovieId());
//		out.printf("<input type='hidden' name='userId' value='%d'/>\n", review.getUserId());

		out.println("<div class='form-group'>");
		out.println("<label for='review'>Review:</label>");
		// Autofill the review field
		out.printf("<textarea name='review' class='form-control' required>%s</textarea>\n", review.getReview());
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='rating'>Rating:</label>");
		// Autofill the rating field
		out.printf("<input type='number' name='rating' class='form-control' required value='%d'/>\n", review.getRating());
		out.println("</div>");

		out.println("<button type='submit' class='btn btn-primary'>Update Review</button>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewId = req.getParameter("reviewId"); // from hidden form field
		String movieId = req.getParameter("movieId"); // from input text
		String u1 = req.getParameter("userId");
		String reviewText = req.getParameter("review"); // from input text area
		String rating = req.getParameter("rating"); // from input text (assuming it's numeric)
		
		String userId = "";
		Cookie[] arr = req.getCookies();
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("userId")) {
					userId = c.getValue();
				}
			}
		}
		// Assuming Review class has appropriate constructor and setter methods
		Reviews review = new Reviews();
//		review.setReviewId(Integer.parseInt(reviewId));
		review.setMovieId(Integer.parseInt(movieId));
		review.setUserId(Integer.parseInt(userId));
		review.setReview(reviewText);
		review.setRating(Integer.parseInt(rating));
		review.setReviewId(Integer.parseInt(reviewId));
		review.setModified(Calendar.getInstance().getTime());
		int updateCount = 0;

		try (ReviewsDao reviewDao = new ReviewsDao()) {
		    reviewDao.editReview(review);
		} catch (Exception e) {
		    e.printStackTrace();
		    throw new ServletException(e);
		}

		resp.sendRedirect("reviews?type=my");

	}
	
	
	
}
