package tests;


//import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import junit.framework.TestCase;
import beans.User;
import smart.Display;
import smart.HealthDataHelper;
import java.util.ArrayList;

public class HealthDataServletMockTest extends TestCase{
	
	private final Mockery testContext = new Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
};

@Test
public void getuserdata() throws IOException, ServletException {
	
	final models.HealthData model = testContext.mock(models.HealthData.class);
	

    HealthDataHelper hp = new HealthDataHelper();
    
      
	
	testContext.checking(new Expectations() {
		{
			oneOf(model).getData("eu1");
		}

	});
	
	hp.getuserdata("eu1", model);
	
	testContext.assertIsSatisfied();
	
	
}



}
