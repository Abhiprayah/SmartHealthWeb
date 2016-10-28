package smart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Address;
import beans.Admin;
import beans.User;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdmin")
public class UpdateAdmin extends HttpServlet implements UserForm{
	private static final long serialVersionUID = 1L;
	
	private final static int FIRST_NAME = 0;
	private final static int LAST_NAME = 1;
	private final static int SECONDARY_EMAIL = 2;
	private final static int PASSWORD = 3;
	private final static int STREET_NUMBER = 4;
	private final static int STREET_NAME = 5;
	private final static int MAJOR_MUNICIPALITY = 6;
	private final static int GOVERNING_DISTRICT = 7;
	private final static int POSTAL_AREA = 8;
	private final static int ABOUT_ME = 9;
	private final static int PROFILE_PIC1 = 10;
	private final static int PROFILE_PIC2 = 11;
	private final static int PROFILE_PIC3 = 12;
	
	//Options for signup
	private static final String options[] = {"firstName", "lastName", 
			"secondaryEmail", "password",
			"streetNumber", "streetName", "majorMunicipality", 
			"governingDistrict", "postalArea",
			"about", "profilePicLink1","profilePicLink2","profilePicLink3"}; 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		models.Update model = new models.Update();
		String commonDetails[] = new String[13];
		for(int i=0;i<options.length;i++){
			commonDetails[i] = request.getParameter(options[i]);
		}
		String emergencyContact = request.getParameter("emergencyContact");
		
		User curUser = (User)request.getSession(false).getAttribute("curUser");
		
		User user = new Admin(commonDetails[FIRST_NAME],commonDetails[LAST_NAME], "",
				commonDetails[SECONDARY_EMAIL],commonDetails[PASSWORD], "",
				new Address(commonDetails[STREET_NUMBER], commonDetails[STREET_NAME],
						commonDetails[MAJOR_MUNICIPALITY], commonDetails[GOVERNING_DISTRICT], 
						commonDetails[POSTAL_AREA]), 
				commonDetails[ABOUT_ME],commonDetails[PROFILE_PIC1],
				commonDetails[PROFILE_PIC2], commonDetails[PROFILE_PIC3],false, emergencyContact);
		
		String errormessage = validateUser(user);
		if(errormessage == null){
			curUser.setFirstName(commonDetails[FIRST_NAME]);
			model.updateHelper("User","FirstName",curUser.getFirstName(),curUser.getUserId());
			curUser.setLastName(commonDetails[LAST_NAME]);
			model.updateHelper("User","LastName",curUser.getLastName(),curUser.getUserId());
			curUser.setSecondaryEmail(commonDetails[SECONDARY_EMAIL]);
			model.updateHelper("User","Email2",curUser.getSecondaryEmail(),curUser.getUserId());
			curUser.setPassword(commonDetails[PASSWORD]);
			model.updateHelper("User","Password",curUser.getPassword(),curUser.getUserId());
			curUser.setPostalAddress(new Address(commonDetails[STREET_NUMBER], commonDetails[STREET_NAME],
						commonDetails[MAJOR_MUNICIPALITY], commonDetails[GOVERNING_DISTRICT], 
						commonDetails[POSTAL_AREA]));
			model.updateAddressHelper(curUser.getPostalAddress(), curUser.getUserId());
			curUser.setAboutMe(commonDetails[ABOUT_ME]);
			model.updateHelper("User","AboutMe",curUser.getAboutMe(),curUser.getUserId());
			String picUrls[] = {commonDetails[PROFILE_PIC1], commonDetails[PROFILE_PIC2], commonDetails[PROFILE_PIC3]};
			curUser.setPicURL(picUrls);
			model.updateHelper("User","PhotoURL1",curUser.getPicURL()[0],curUser.getUserId());
			model.updateHelper("User","PhotoURL2",curUser.getPicURL()[1],curUser.getUserId());
			model.updateHelper("User","PhotoURL3",curUser.getPicURL()[2],curUser.getUserId());
			((Admin)curUser).setEmergencyContact(emergencyContact);
			model.updateHelper("Administrator", "Phone", emergencyContact, curUser.getUserId());
			response.sendRedirect("/SmartHealthWeb/validuser/loggedin.jsp");
		}else{
			PrintWriter pw = response.getWriter();
			pw.println(errormessage);
			pw.close();
		}
		
	}
	
	public String validateUser(User user){
		if(user.getFirstName() == null || user.getFirstName().isEmpty()){
			return "FirstName is empty";
		}
		if(user.getLastName() == null || user.getLastName().isEmpty()){
			return "Last Name is empty";
		}
		if(user.getSecondaryEmail() == null || user.getSecondaryEmail().isEmpty() 
				|| user.getSecondaryEmail().equalsIgnoreCase(user.getPrimaryEmail()) || !isValidEmail(user.getSecondaryEmail())){
			return "Invalid Secondary Email";
		}
		if(user.getPassword() == null || user.getPassword().isEmpty()){
			return "Password Empty";
		}
		if(!isValidURL(user.getPicURL()[0]) || !isValidURL(user.getPicURL()[1]) || !isValidURL(user.getPicURL()[2])){
			return "Invalid picture URLS";
		}
		if(((Admin)user).getEmergencyContact() == null || !this.isValidContactNumber(((Admin)user).getEmergencyContact())){
			return "Invalid Contact number";
		}
		return null;
	}

}
