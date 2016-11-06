package smart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Moderator;
import beans.Post;
import beans.PostIdentifier;
import beans.User;

/**
 * Servlet implementation class Forum
 */
@WebServlet("/Forum")
public class Forum extends HttpServlet implements UserForm{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		User user = (User)request.getSession(false).getAttribute("curUser");
		models.Forums model = new models.Forums();
		String forumID = request.getParameter("forumID");
		if(model.isClosed(Integer.parseInt(forumID))){
			PrintWriter pw = response.getWriter();
			pw.print("Forum has been closed and cannot be modified");
			pw.close();
			return;
		}
		beans.Forum forum = model.getForumContent(Integer.parseInt(forumID));
		String postID = request.getParameter("postID");
		if(request.getParameter("postSubmit") != null){
			String post = request.getParameter("post");
			String photoLocation = request.getParameter("photoLocation");
			String videoLocation = request.getParameter("videoLocation");
			String linkLocation = request.getParameter("linkLocation");
			boolean areValidLinks = validateLinks(photoLocation, videoLocation, linkLocation);
			if(post!=null && !post.isEmpty() && areValidLinks){
				model.post(Integer.parseInt(forumID), user.getUserId(), post, photoLocation, linkLocation, videoLocation);
				response.sendRedirect("/SmartHealthWeb/validuser/forum.jsp?id=" + forumID);
			}else if(!areValidLinks){
				PrintWriter pw = response.getWriter();
				pw.println("Links are not valid");
			}else{
				PrintWriter pw = response.getWriter();
				pw.println("Post field cannot be empty");
			}
		}else if(request.getParameter("RatingSubmit") != null){
			String rating = request.getParameter("rating");
			if(rating != null && !rating.isEmpty()){
				PostIdentifier pi = findPostbyID(forum, Integer.parseInt(postID));
				model.ratePost(pi.getUserName(), pi.getTimeCreated(), user.getUserId(), Integer.parseInt(rating));
				response.sendRedirect("/SmartHealthWeb/validuser/forum.jsp?id=" + forumID);
			}else{
				PrintWriter pw = response.getWriter();
				pw.print("Rating not received");
			}
		}else if(request.getParameter("CommentSubmit") != null){
			String comment = request.getParameter("comment");
			String photoLocation = request.getParameter("photoLocation");
			String videoLocation = request.getParameter("videoLocation");
			String linkLocation = request.getParameter("linkLocation");
			boolean areValidLinks = validateLinks(photoLocation, videoLocation, linkLocation);
			if(comment!=null && !comment.isEmpty() && areValidLinks){
				PostIdentifier pi = findPostbyID(forum, Integer.parseInt(postID));
				model.commentOnPost(pi.getUserName(), pi.getTimeCreated(), user.getUserId(), comment, photoLocation, linkLocation, videoLocation);
				response.sendRedirect("/SmartHealthWeb/validuser/forum.jsp?id=" + forumID);
			}else if(!areValidLinks){
				PrintWriter pw = response.getWriter();
				pw.println("Links are not valid");
			}else{
				PrintWriter pw = response.getWriter();
				pw.print("Comment cannot be empty");
			}
		}else if(request.getParameter("closeForum") != null){
			model.closeForum(Integer.parseInt(forumID), (Moderator)user);
			response.sendRedirect("SmartHealthWeb/validuser/moderator/forums.jsp");
		}
	}

	private PostIdentifier findPostbyID(beans.Forum forum, int id){
		ArrayList<Post> posts = forum.getPosts();
		for(Post p : posts){
			if(p.getID() == id){
				return new PostIdentifier(p.getUsername(),p.getTimeCreated());
			}
		}
		return null;
	}
	
	private boolean validateLinks(String photoLocation, String videoLocation, String linkLocation){
		if(photoLocation != null && !photoLocation.isEmpty() && !this.isValidURL(photoLocation)){
			return false;
		}
		if(videoLocation != null && !videoLocation.isEmpty() && !this.isValidURL(videoLocation)){
			return false;
		}
		if(linkLocation != null && !linkLocation.isEmpty() && !this.isValidURL(linkLocation)){
			return false;
		}
		return true;
	}
	
}
