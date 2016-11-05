package smart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Moderator;

/**
 * Servlet implementation class ForumCreation
 */
@WebServlet("/ForumCreation")
public class ForumCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForumCreation() {
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
		models.ForumList model = new models.ForumList();
		Moderator moderator = (Moderator)request.getSession(false).getAttribute("curUser");
		String forumTitle = request.getParameter("forumTitle");
		String forumDesc = request.getParameter("forumDesc");
		if(forumTitle.isEmpty()){
			PrintWriter pw = response.getWriter();
			pw.println("Title cannot be empty");
			pw.close();
		}else{
			model.createForum(forumTitle, forumDesc, moderator);
			response.sendRedirect("/SmartHealthWeb/validuser/moderator/forums.jsp");
		}
	}

}
