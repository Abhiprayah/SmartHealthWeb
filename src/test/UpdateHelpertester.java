package test;

import org.junit.Test;

import beans.User;
import junit.framework.TestCase;
import smart.UpdateHelper;

public class UpdateHelpertester extends TestCase {

	@Test
	public void testCreateUpdatedUser() {
		UpdateHelper helper = new UpdateHelper();
		
		String[] details = {"a", "a", "as@as.com", "a", 
				"a", "a", "a", "a", "a", 
				"a", "https://a1.com", "https://a2.com", "https://a3.com"};
		
		User correctUser = new beans.EndUser("a", "a", "", "as@as.com", "a", 
				"", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		
		User user = helper.createUpdatedUser(details);
		
		assertEquals(correctUser.getFirstName(), user.getFirstName());
		assertEquals(correctUser.getLastName(), user.getLastName());
		assertEquals(correctUser.getSecondaryEmail(), user.getSecondaryEmail());
		assertEquals(correctUser.getPassword(), user.getPassword());
		assertEquals(correctUser.getPostalAddress().getStreetName(), user.getPostalAddress().getStreetName());
		assertEquals(correctUser.getPostalAddress().getStreetNumber(), user.getPostalAddress().getStreetNumber());
		assertEquals(correctUser.getPostalAddress().getMajorMunicipality(), user.getPostalAddress().getMajorMunicipality());
		assertEquals(correctUser.getPostalAddress().getGoverningDistrict(), user.getPostalAddress().getGoverningDistrict());
		assertEquals(correctUser.getPostalAddress().getPostalArea(), user.getPostalAddress().getPostalArea());
		assertEquals(correctUser.getAboutMe(), user.getAboutMe());
		assertEquals(correctUser.getPicURL()[0], user.getPicURL()[0]);
		assertEquals(correctUser.getPicURL()[1], user.getPicURL()[1]);
		assertEquals(correctUser.getPicURL()[2], user.getPicURL()[2]);
		assertEquals(correctUser.hasQuit(), user.hasQuit());
	}
	/*
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testValidateUser() {
		String errMessage;
		UpdateHelper helper = new UpdateHelper();
		
		User user = new beans.EndUser("a", "a", "a@a.com", "as@as.com", "a", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, null);
		
		user = new beans.EndUser("", "a", "a@a.com", "as@as.com", "a", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, "FirstName is empty");
		
		user = new beans.EndUser("a", "", "a@a.com", "as@as.com", "a", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, "Last Name is empty");
		
		user = new beans.EndUser("a", "a", "a@a.com", "as@as.com", "", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, "Password Empty");
		
		user = new beans.EndUser("a", "a", "a@a.com", "as@as.com", "a", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "a2", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, "Invalid picture URLS");
		
		user = new beans.EndUser("a", "a", "a@a.com", "as", "a", 
				"a", new beans.Address("a", "a", "a", "a", "a"), 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		errMessage = helper.validateUser(user);
		assertEquals(errMessage, "Invalid Secondary Email");
		
	}

}
