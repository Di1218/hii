package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testSet.TestSet;

public class Demo_Test extends TestSet{
	
	@BeforeMethod
	public void beforeDemoPage()
	{
		getLogin_page().clickDemo();
	}
	
	@Test
	public void demoHeading()
	{
		getDemo_page().getHeading().getText();
		System.out.println(getDemo_page().getHeading().getText());
		Assert.assertTrue(getDemo_page().getHeading().isDisplayed());
		
	}
	
	@AfterMethod
	public void teatDown()
	{
		driver.quit();
	}

}
