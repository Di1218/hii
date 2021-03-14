package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demo_Page {
	public WebDriver driver;

	public Demo_Page(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'OpenCart Demonstration')]")
	private WebElement heading;
	public WebElement getHeading()
	{
		return heading;
	}
	
	
	

}
