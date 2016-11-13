package smart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class UpdateEndUser
 */
@WebServlet("/UpdateEndUser")
public class UpdateEndUser extends HttpServlet implements UserForm{
	private static final long serialVersionUID = 1L;
    
	//Options for signup
	private static final String options[] = {"firstName", "lastName", 
			"secondaryEmail", "password",
			"streetNumber", "streetName", "majorMunicipality", 
			"governingDistrict", "postalArea",
			"about", "profilePicLink1","profilePicLink2","profilePicLink3"}; 
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEndUser() {
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
		models.Update model = new models.Update();
		UpdateHelper helper = new UpdateHelper();
		String commonDetails[] = new String[13];
		for(int i=0;i<options.length;i++){
			commonDetails[i] = request.getParameter(options[i]);
		}
		
		User curUser = (User)request.getSession(false).getAttribute("curUser");
		
		User user = helper.createUpdatedUser(commonDetails);
		String errormessage = helper.validateUser(user);
		if(errormessage == null){
			helper.updateUser(curUser, commonDetails, model);
			response.sendRedirect("/SmartHealthWeb/validuser/loggedin.jsp");
		}else{
			PrintWriter pw = response.getWriter();
			pw.println(errormessage);
			pw.close();
		}
		
	}

}
