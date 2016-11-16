package tests;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import smart.HealthDataHelper;

public class HealthDataTest {
	
	private final Mockery testContext = new Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
};

	@Test
	public void testGetuserdata() {
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
	
	
