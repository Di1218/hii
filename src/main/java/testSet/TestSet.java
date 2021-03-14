package testSet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pages.Demo_Page;
import pages.Login_Page;
import testUtil.TestUtil;
import testUtil.WebDriverListener1;

public class TestSet {

	public WebDriver driver;
	public static Properties prop;
	public Login_Page login_page;
	
	public Login_Page getLogin_page() {
		return login_page;
	}
	public Demo_Page demo_page;
	public Demo_Page getDemo_page() {
		return demo_page;
	}
	
	public TestUtil testutil;
	public TestUtil getTestutil() {
		return testutil;
	}
	
	public WebDriverListener1 webdriverlistener1;
	public WebDriverListener1 getWebdriverlistener1() {
		return webdriverlistener1;
	}

	public EventFiringWebDriver eventfiringwebdriver;
	public EventFiringWebDriver getEventfiringwebdriver() {
		return eventfiringwebdriver;
	}

	public TestSet()
	{
		try {
			prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\Dipali Tailor\\eclipse\\OpenCartWeb\\src\\main\\java\\environmentVariables\\config.properties");
			prop.load(file);
		}
	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}
	
	public void driverset()
	{ 
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dipali Tailor\\Desktop\\jarfile\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser is not defined in the properties file");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(getTestutil().PageLoad_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(getTestutil().Implicitly_Wait, TimeUnit.SECONDS);

		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		}
	
	
	@Parameters({"browser"})
	@BeforeClass
	public void objectSetup()
	{
		driverset();
		login_page=new Login_Page(driver);
		testutil=new TestUtil(driver);
		demo_page=new Demo_Page(driver);
		testutil=new TestUtil(driver);
		eventfiringwebdriver=new EventFiringWebDriver(driver);
		 
		 webdriverlistener1=new WebDriverListener1();
		 eventfiringwebdriver.register(webdriverlistener1);
		 driver=eventfiringwebdriver;
		
		
		
	}

	
	

}