package smart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Address;
import beans.Moderator;
import beans.Qualification;
import beans.User;

/**
 * Servlet implementation class SignUpModerator
 */
@WebServlet("/SignUpModerator")
public class SignUpModerator extends HttpServlet implements UserForm{
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
    public SignUpModerator() {
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
		models.SignUp model = new models.SignUp();
		String commonDetails[] = new String[15];
		for(int i=0;i<options.length;i++){
			commonDetails[i] = request.getParameter(options[i]);
		}
		String emergencyContact = request.getParameter("emergencyContact");
		
		String qualmessage = null;
		String qualificationChoices[] = request.getParameter("qualifications").split(" ");
		TreeSet<Integer> qualChoices = new TreeSet<Integer>();
		for(String s : qualificationChoices){
			if(!s.isEmpty()) qualChoices.add(Integer.parseInt(s));
		}
		ArrayList<Qualification> acceptedQualifications = model.getQualifications();
		ArrayList<Qualification> qualifications = new ArrayList<Qualification>();
		for(int i : qualChoices){
			//Check and add qualifications and return in case of error
			if(i > 0 && i <= acceptedQualifications.size()){
				qualifications.add(acceptedQualifications.get(i-1));
			}
			else{
				qualmessage = "Invalid Qualification Choices";
			}
		}
		
		User user = new Moderator(commonDetails[FIRST_NAME],commonDetails[LAST_NAME],commonDetails[PRIMARY_EMAIL],
				commonDetails[SECONDARY_EMAIL],commonDetails[PASSWORD],commonDetails[USERID],
				new Address(commonDetails[STREET_NUMBER], commonDetails[STREET_NAME],
						commonDetails[MAJOR_MUNICIPALITY], commonDetails[GOVERNING_DISTRICT], 
						commonDetails[POSTAL_AREA]), 
				commonDetails[ABOUT_ME],commonDetails[PROFILE_PIC1],
				commonDetails[PROFILE_PIC2], commonDetails[PROFILE_PIC3],false,emergencyContact, qualifications);
		
		String errormessage = validateUser(user);
		if(errormessage == null && qualmessage == null){
			model.store(user);
			response.sendRedirect("login.jsp");
		}else{
			PrintWriter pw = response.getWriter();
			if(errormessage != null)
				pw.println(errormessage);
			if(qualmessage != null)
				pw.println(qualmessage);
			pw.close();
		}
	}

	public String validateUser(User user){
		models.SignUp model = new models.SignUp();
		if(user.getFirstName() == null || user.getFirstName().isEmpty()){
			return "FirstName is empty";
		}
		if(user.getLastName() == null || user.getLastName().isEmpty()){
			return "Last Name is empty";
		}
		if(user.getPrimaryEmail() == null || user.getPrimaryEmail().isEmpty() || !isValidEmail(user.getPrimaryEmail())){
			return "Invalid Primary Email";
		}else if(model.primaryEmailIDExists(user.getPrimaryEmail())){
			return "Primary Email ID already registered";
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
		if(user.getUserId() == null || user.getUserId().isEmpty() || user.getUserId().length() > 20){
			return "Invalid user name";
		}else if(model.userIDExists(user.getUserId())){
			return "User name already taken";
		}
		if(((Moderator)user).getEmergencyContact() == null || !isValidContactNumber( ((Moderator)user).getEmergencyContact() )){
			return "Emergency Contact number is invalid";
		}
		if(((Moderator)user).getQualifications() == null || ((Moderator)user).getQualifications().isEmpty()){
			return "No qualifications";
		}
		return null;
	}
}
