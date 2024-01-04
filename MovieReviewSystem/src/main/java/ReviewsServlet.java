import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviews")
public class ReviewsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String rating = req.getParameter("rating");
		String review = req.getParameter("review");
		String uId = req.getParameter("userId");
//		System.out.println(uId);
		try (ReviewsDao reviewDao = new ReviewsDao()) {
			Reviews rev = new Reviews();
			rev.setMovieId(Integer.parseInt(id));
			rev.setRating(Integer.parseInt(rating));
			rev.setReview(review);
			rev.setUserId(Integer.parseInt(uId));
			reviewDao.save(rev);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = "";
		Cookie[] arr = req.getCookies();
		String type = req.getParameter("type");
		if (arr != null) {
			for (Cookie c : arr) {
				if (c.getName().equals("userId")) {
					userId = c.getValue();
				}
			}
		}
		List<Reviews> reviewList = new ArrayList<>();
		Integer id = Integer.parseInt(userId);
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		try (ReviewsDao reviewDao = new ReviewsDao()) {
			if (type.equals("all")) {
				reviewList = reviewDao.getAllReviews();
			}
			else if (type.equals("my")) {
				reviewList = reviewDao.getAllReviewsByUserId(id);
			}
			else if (type.equals("shared")){
				reviewList = reviewDao.getAllReviewsSharedWithMe(id);
				System.out.println(reviewList.size());
				
			}
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Reviews</title>");
			out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
			out.println("</head>");
			out.println("<body class='container'>");
			out.println("<h4 class='mb-4'>Here's the list of Reviews</h4>");
			out.println("<hr/>");
			out.println("<div class='mb-4'>");
			out.println("<a href='reviews?type=all' class='btn btn-primary mr-2'>All Reviews</a>");
			out.println("<a href='reviews?type=my' class='btn btn-primary mr-2'>My Reviews</a>");
			out.println("<a href='reviews?type=shared' class='btn btn-primary'>Shared Reviews</a>");
			out.println("</div>");
			
			out.println("<table class=\"table table-bordered\">");
			out.println("<thead class=\"thead-dark\">");
			out.println("<tr>");
			out.println("<th scope=\"col\">Review ID</th>");
			out.println("<th scope=\"col\">Movie ID</th>");
			out.println("<th scope=\"col\">Review</th>");
			out.println("<th scope=\"col\">Rating</th>");
			out.println("<th scope=\"col\">User ID</th>");
			out.println("<th scope=\"col\">Modified Date</th>");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			for (Reviews review : reviewList) {
				
				out.println("<tr>");
			    out.printf("<th scope=\"row\">%d</th>", review.getReviewId());
			    out.printf("<td>%d</td>", review.getMovieId());
			    out.printf("<td>%s</td>", review.getReview());
			    out.printf("<td>%d</td>", review.getRating());
			    out.printf("<td>%d</td>", review.getUserId());
			    out.printf("<td>%tF</td>", review.getModified()); 
			    out.println("</tr>");


			    if (type.equals("my")) {
			        out.printf("<td><a href='editreview?rId=%d' class='btn btn-outline-danger'>Edit</a> " +
			                   "<a href='deletereview?rId=%d' class='btn btn-outline-danger'>Delete</a> " +
			                   "<a href='sharereview?rId=%d' class='btn btn-outline-info'>Share</a></td>",
			                   review.getReviewId(), review.getReviewId(), review.getReviewId());
			    } 

			    out.println("</div>");
			    out.println("</div>");
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
