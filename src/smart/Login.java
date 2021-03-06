package smart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getSession(false) != null){
			if(request.getSession(false).getAttribute("curUser") != null){
				request.getSession(false).setAttribute("curUser", null);
			}
			request.getSession(false).invalidate();
		}
		
		if(request.getParameter("Login") != null){
			String ID = request.getParameter("EmailID");
			String password = request.getParameter("Password");
			models.Login model = new models.Login();
			beans.User curUser = model.validUser(ID, password);
			if(curUser != null){
				request.getSession().setAttribute("curUser", curUser);
				if(!curUser.hasQuit()) response.sendRedirect("validuser/loggedin.jsp");
				else response.sendRedirect("validuser/join.jsp");
			}else{
				PrintWriter pw = response.getWriter();
				pw.println("User ID or Password invalid");
				pw.close();
			}
		}else if(request.getParameter("SignUp") != null){
			response.sendRedirect("signup.jsp");
		}
	}

}
