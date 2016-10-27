package smart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Friends
 */
@WebServlet("/Friends")
public class Friends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private models.Friends model = new models.Friends();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friends() {
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
		
		HttpSession session = request.getSession(false);
		beans.User curUser = (beans.User)session.getAttribute("curUser");
		
		if(request.getParameter("viewfriends")!=null)
		{
			ArrayList<String> friendslist = model.viewFriends(curUser);
			StringBuffer viewFriendsOutput  = new StringBuffer();
			viewFriendsOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); </script><p>your friends:</p>");
			if(friendslist == null)
			{
				viewFriendsOutput.append("<p>No Friends...</p>");
				
			}
			else
			{
				for(int i = 0 ; i < friendslist.size(); i++)
				{
					viewFriendsOutput.append("<li>" + friendslist.get(i) + "</li>");
				}
			}
			request.setAttribute("viewFriendsOutput", viewFriendsOutput.toString());
			request.getRequestDispatcher("/validuser/enduser/Friends.jsp").forward(request, response);
		}
		else if(request.getParameter("sendrequest")!=null)
		{
			String friendname = request.getParameter("reqfriendusername");
			StringBuffer sendFriendRequestOutput = new StringBuffer();
			if(friendname.equals(curUser.getUserId()))
			{
				sendFriendRequestOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('you cannot send friend request to yourself') </script>");
				request.setAttribute("sendFriendRequestOutput", sendFriendRequestOutput.toString());
				request.getRequestDispatcher("/validuser/enduser/Friends.jsp").forward(request, response);
			}
			else
			{
				sendFriendRequestOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert(' " + model.sendFriendRequest(friendname, curUser) + " ') </script>");
				request.setAttribute("sendFriendRequestOutput", sendFriendRequestOutput.toString());
				request.getRequestDispatcher("/validuser/enduser/Friends.jsp").forward(request, response);
			}
		}
		
			
	}

}
