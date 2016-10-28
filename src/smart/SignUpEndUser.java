package smart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Address;
import beans.EndUser;
import beans.User;

/**
 * Servlet implementation class SignUpEndUser
 */
@WebServlet("/SignUpEndUser")
public class SignUpEndUser extends HttpServlet implements UserForm{
	private static final long serialVersionUID = 1L;
	private final static int FIRST_NAME = 0;
	private final static int LAST_NAME = 1;
	private final static int PRIMARY_EMAIL = 2;
	private final static int SECONDARY_EMAIL = 3;
	private final static int PASSWORD = 4;
	private final static int USERID = 5;
	private final static int STREET_NUMBER = 6;
	private final static int STREET_NAME = 7;
	private final static int MAJOR_MUNICIPALITY = 8;
	private final static int GOVERNING_DISTRICT = 9;
	private final static int POSTAL_AREA = 10;
	private final static int ABOUT_ME = 11;
	private final static int PROFILE_PIC1 = 12;
	private final static int PROFILE_PIC2 = 13;
	private final static int PROFILE_PIC3 = 14;
	
	//Options for signup
	private static final String options[] = {"firstName", "lastName", 
			"primaryEmail",
			"secondaryEmail", "password", "username",
			"streetNumber", "streetName", "majorMunicipality", 
			"governingDistrict", "postalArea",
			"about", "profilePicLink1","profilePicLink2","profilePicLink3"}; 
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpEndUser() {
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
		String commonDetails[] = new String[15];
		for(int i=0;i<options.length;i++){
			commonDetails[i] = request.getParameter(options[i]);
		}
		
		User user = new EndUser(commonDetails[FIRST_NAME],commonDetails[LAST_NAME],commonDetails[PRIMARY_EMAIL],
				commonDetails[SECONDARY_EMAIL],commonDetails[PASSWORD],commonDetails[USERID],
				new Address(commonDetails[STREET_NUMBER], commonDetails[STREET_NAME],
						commonDetails[MAJOR_MUNICIPALITY], commonDetails[GOVERNING_DISTRICT], 
						commonDetails[POSTAL_AREA]), 
				commonDetails[ABOUT_ME],commonDetails[PROFILE_PIC1],
				commonDetails[PROFILE_PIC2], commonDetails[PROFILE_PIC3],false);
		
		boolean validuser = validateUser(user);
		
		models.SignUp model = new models.SignUp();
		model.store(user);
		response.sendRedirect("login.jsp");
	}

	public boolean validateUser(User user){
		if(user.getFirstName() == null || user.getFirstName().isEmpty()){
			return false;
		}
		if(user.getLastName() == null || user.getLastName().isEmpty()){
			return false;
		}
		if(user.getPrimaryEmail() == null || user.getPrimaryEmail().isEmpty() || user.getPrimaryEmail()){
			return false;
		}
		if(user.getSecondaryEmail() == null || user.getSecondaryEmail().isEmpty()){
			return false;
		}
		if(user.getPassword() == null || user.getPassword().isEmpty()){
			return false;
		}
	}
	
}
