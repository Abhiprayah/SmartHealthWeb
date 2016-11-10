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
 * Servlet implementation class HealthData
 */
@WebServlet("/HealthData")
public class HealthData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private models.HealthData model = new models.HealthData();
	private models.Friends friendsModel = new models.Friends();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthData() {
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
		if(request.getParameter("adddata")!=null)
		{
			ArrayList<String> healthPropertiesValues = new ArrayList<String>();
			String distance = request.getParameter("distance");
			String calory = request.getParameter("caloryinput");
			String sysbp = request.getParameter("sysbpinput");
			String diabp = request.getParameter("diabpinput");
			healthPropertiesValues.add(distance);
			healthPropertiesValues.add(calory);
			healthPropertiesValues.add(sysbp);
			healthPropertiesValues.add(diabp);
			model.newData(healthPropertiesValues, curUser);
			
			StringBuffer addDataOutput = new StringBuffer();
			
			addDataOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('Health Data Stored Successfully'); window.location.replace('http://localhost:8080/SmartHealthWeb/validuser/healthdata.jsp') </script>");
			request.setAttribute("addDataOutput", addDataOutput.toString());
			request.getRequestDispatcher("/validuser/healthdata.jsp").forward(request, response);
		}
		else if(request.getParameter("userhealthreport")!=null)
		{
			if(model.ifDataExists(curUser))
			{
				ArrayList<String> userData = model.getData(curUser.getUserId());
				
				StringBuffer healthReportOutput = new StringBuffer();
				
				healthReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]);  </script>" + "<ul> <li>Distance ran: " +  userData.get(0)
				                          + "</li> <li>Calories burned: " + userData.get(1) + "</li> <li>Systolic Blood Pressure: " + userData.get(2)
                                          + "</li> <li>Diastolic blood pressure: " + userData.get(3) + "</li> </ul>");
				request.setAttribute("healthReportOutput", healthReportOutput.toString());
				request.getRequestDispatcher("/validuser/healthdata.jsp").forward(request, response);
			}
			else
			{
				StringBuffer healthReportOutput = new StringBuffer();
				
				healthReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('Health Data does not exist'); window.location.replace('http://localhost:8080/SmartHealthWeb/validuser/healthdata.jsp') </script>");
				request.setAttribute("healthReportOutput", healthReportOutput.toString());
				request.getRequestDispatcher("/validuser/healthdata.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("friendreportsubmit")!=null)
		{
			String friendname = request.getParameter("friendusername");
			StringBuffer friendReportOutput = new StringBuffer();
			if(friendsModel.ifUserExists(friendname))
			{
				if(friendsModel.isalreadyafriend(friendname, curUser))
				{
					ArrayList<String> userData = model.getData(friendname);
					
					
					if(userData!=null)
					{
						
						
						friendReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]);  </script>" + "<ul> <li>Distance ran: " +  userData.get(0)
						                          + "</li> <li>Calories burned: " + userData.get(1) + "</li> <li>Systolic Blood Pressure: " + userData.get(2)
		                                          + "</li> <li>Diastolic blood pressure: " + userData.get(3) + "</li> </ul>");
					}
					else
					{
						friendReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('No data of friend exists!!'); window.location.replace('http://localhost:8080/SmartHealthWeb/validuser/healthdata.jsp') </script>");
					}
					
					
				}
				else
				{
					friendReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('You cannot see Health data of a non-frined!!'); window.location.replace('http://localhost:8080/SmartHealthWeb/validuser/healthdata.jsp') </script>");
				}
			}
			else
			{
				friendReportOutput.append("<script> document.forms[0].parentNode.removeChild(document.forms[0]); alert('Username does'nt exist!!!'); window.location.replace('http://localhost:8080/SmartHealthWeb/validuser/healthdata.jsp') </script>");
			}
			request.setAttribute("friendReportOutput", friendReportOutput.toString());
			request.getRequestDispatcher("/validuser/healthdata.jsp").forward(request, response);
		}
	}

}
