package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public WebDriver driver;

	public Login_Page(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private WebElement email;
	public WebElement getEmail()
	{
		return email;
	}
	
	@FindBy(name="password")
	private WebElement pass;
	public WebElement getPass()
	{
		return pass;
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")
	private WebElement login;
	public WebElement getLogin()
	{
		return login;
	}
	
	@FindBy(name="pin")
	private WebElement pin;
	public WebElement getPin()
	{
		return pin;
	}
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Demo')]")
	private WebElement demoClick;
	public WebElement getDemoClick()
	{
		return demoClick;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Resources ')]")
	private WebElement resources;
	public WebElement getResources()
	{
		return resources;
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu']//a[contains(text(),'Download')]")
	private WebElement download;
	public WebElement getDowload()
	{
		return download;
	}
		
	public void clickDemo()
	{
		getDemoClick().click();
	}
	
	public void login(String email, String password)
	{
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg hidden-xs']")).click();
	}
	
	

}
