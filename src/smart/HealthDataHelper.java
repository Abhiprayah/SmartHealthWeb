package smart;

import java.util.ArrayList;

public class HealthDataHelper {

	public ArrayList<String> getuserdata(String userName,models.HealthData health)
	{
		ArrayList<String>userdata = new ArrayList<String>();
		
		
	userdata = health.getData(userName);
			
	return userdata;
	}
}
