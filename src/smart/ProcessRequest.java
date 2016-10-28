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
 * Servlet implementation class ProcessRequest
 */
@WebServlet("/ProcessRequest")
public class ProcessRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private models.Friends model = new models.Friends();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessRequest() {
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
		if(session.getAttribute("pendingrequests")!=null)
		{
			ArrayList<String> pendingrequests = (ArrayList<String>)session.getAttribute("pendingrequests");
			for(Integer i = 0;i<pendingrequests.size();i++)
			{
				if(request.getParameter(i.toString())!=null)
				{
					model.acceptrequest(pendingrequests.get(i), curUser);
				}
			}
			for(Integer i = 0;i<pendingrequests.size();i++)
			{
				if(request.getParameter(i.toString())==null)
				{
					model.rejectrequest(pendingrequests.get(i), curUser);
				}
			}
			session.setAttribute("pendingrequests", null);
			response.sendRedirect("/SmartHealthWeb/validuser/enduser/Friends.jsp");
		}
		else
			response.sendRedirect("/SmartHealthWeb/validuser/enduser/loggedin.jsp");
		
	}

}
