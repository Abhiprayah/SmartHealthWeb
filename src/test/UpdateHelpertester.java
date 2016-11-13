package test;

import org.jmock.Mockery;
import org.junit.Test;
import org.jmock.Expectations;
import org.jmock.lib.legacy.ClassImposteriser;

import beans.User;
import junit.framework.TestCase;
import smart.UpdateHelper;

public class UpdateHelpertester extends TestCase {

	private final static int FIRST_NAME = 0;
	private final static int LAST_NAME = 1;
	private final static int SECONDARY_EMAIL = 2;
	private final static int PASSWORD = 3;
	private final static int ABOUT_ME = 9;
	private final static int PROFILE_PIC1 = 10;
	private final static int PROFILE_PIC2 = 11;
	private final static int PROFILE_PIC3 = 12;
	
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
	
	@Test
	public void testUpdateUser() {
		Mockery context = new Mockery(){{setImposteriser(ClassImposteriser.INSTANCE);}};
		final models.Update model = context.mock(models.Update.class);
		
		UpdateHelper helper = new UpdateHelper();
		
		String[] details = {"a", "a", "as@as.com", "a", 
				"a", "a", "a", "a", "a", 
				"a", "https://a1.com", "https://a2.com", "https://a3.com"};
		
		beans.Address address = new beans.Address("a", "a", "a", "a", "a"); 
		
		User correctUser = new beans.EndUser("a", "a", "", "as@as.com", "a", 
				"a", address, 
				"a", "https://a1.com", "https://a2.com", "https://a3.com", false);
		
		context.checking(new Expectations(){{
			oneOf(model).updateHelper("User", "FirstName", details[FIRST_NAME], "a");
			oneOf(model).updateHelper("User", "LastName", details[LAST_NAME], "a");
			oneOf(model).updateHelper("User", "Email2", details[SECONDARY_EMAIL], "a");
			oneOf(model).updateHelper("User", "Password", details[PASSWORD], "a");
			oneOf(model).updateAddressHelper(with(any(beans.Address.class)), with(any(String.class)));
			oneOf(model).updateHelper("User", "AboutMe", details[ABOUT_ME], "a");
			oneOf(model).updateHelper("User", "PhotoURL1", details[PROFILE_PIC1], "a");
			oneOf(model).updateHelper("User", "PhotoURL2", details[PROFILE_PIC2], "a");
			oneOf(model).updateHelper("User", "PhotoURL3", details[PROFILE_PIC3], "a");
		}});
		
		helper.updateUser(correctUser, details, model);
		
		context.assertIsSatisfied();
		
	}

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
