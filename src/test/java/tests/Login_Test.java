package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import testSet.TestSet;

public class Login_Test extends TestSet{
	

  String sheetName = "Sheet1"; //here give particularsheet name not excelsheet name

	@Test (enabled=false)
	public void loginTest()
	{
		getLogin_page().getEmail().sendKeys(prop.getProperty("email"));
		getLogin_page().getPass().sendKeys(prop.getProperty("password"));
		getLogin_page().getLogin().click();
		getLogin_page().getResources().click();
		getLogin_page().getDowload().click();
	}
	
	
	@Parameters({"email","password"})
	@Test(enabled=false)
	public void parameterTest(String email, String password)
	{
		getLogin_page().getEmail().sendKeys(email);
		getLogin_page().getPass().sendKeys(password);
		getLogin_page().getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] dataProvider1() throws EncryptedDocumentException, IOException
	{
		Object data[][] =getTestutil().getData(sheetName);
		return data;
	}
	
	@Test(dataProvider="dataProvider1", enabled=false)
	public void dataproviderTest(String email, String password)
	{
		getLogin_page().getEmail().sendKeys(Keys.CONTROL,"a"); //any one line to clear anything on that: either this line or clear()
		getLogin_page().getEmail().sendKeys(email);
		getLogin_page().getEmail().clear();
		getLogin_page().getPass().sendKeys(password);
		getLogin_page().getLogin().click();		
	}
	
	
	@Test
	public void crossBrowserTesting()
	{
		getLogin_page().getEmail().sendKeys(prop.getProperty("email"));
		getLogin_page().getPass().sendKeys(prop.getProperty("password"));
		getLogin_page().getLogin().click();
		getLogin_page().getResources().click();
		getLogin_page().getDowload().click();
		
	}
	
	@Test(enabled=false)
	public void checking()
	{
		getLogin_page().login("dipali@gmail.com", "cccbu");
	}
	
	
	
	
	

}
