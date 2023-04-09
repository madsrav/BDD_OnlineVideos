package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	
	
	@Before(order=0, value="@SmokeTest")
	public void setUpForSmokeTest()
	{
		System.out.println("inside setUpForSmokeTest");
	}
	@Before(order=1)
	public void setUpForRegressionTest()
	{
		System.out.println("inside setUpForRegressionTest");
	}
	@Before(order=2)
	public void setUp()
	{
		System.out.println("inside @Before method ");
	}

	@After(order=2)
	public void teardownForSmokeTest()
	{
		System.out.println("inside teardownForSmokeTest");
	}
	@After(order=1)
	public void teardownForRegressionTest()
	{
		System.out.println("inside teardownForRegressionTest");
	}
	
	@After(order=0)
	public void teardown(Scenario scenario)
	{
	if(scenario.isFailed())
	{
		//write code for screenshot
		
	}
		System.out.println("inside @After method");
	}
}
