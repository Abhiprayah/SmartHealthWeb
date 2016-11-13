package smart;

import beans.Address;
import beans.EndUser;
import beans.User;

public class UpdateHelper implements UserForm{
	
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
	
	public User createUpdatedUser(String commonDetails[]){
		User user = new EndUser(commonDetails[FIRST_NAME],commonDetails[LAST_NAME], "",
				commonDetails[SECONDARY_EMAIL],commonDetails[PASSWORD], "",
				new Address(commonDetails[STREET_NUMBER], commonDetails[STREET_NAME],
						commonDetails[MAJOR_MUNICIPALITY], commonDetails[GOVERNING_DISTRICT], 
						commonDetails[POSTAL_AREA]), 
				commonDetails[ABOUT_ME],commonDetails[PROFILE_PIC1],
				commonDetails[PROFILE_PIC2], commonDetails[PROFILE_PIC3],false);
		return user;
	}
	
	public void updateUser(User curUser, String commonDetails[], models.Update model){
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
		return null;
	}
	
}
