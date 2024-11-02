package SeleniumPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public  LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement usermail= driver.findElement(By.xpath("//input[@id='userEmail']"));
	@FindBy(xpath="//input[@id='userEmail']" )
	WebElement userEmail;
	
	@FindBy(xpath= "//input[@id='userPassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement loginButton;
	
	@FindBy (xpath= "//div[@role='alert']")
	WebElement alert;
	
	public ProductCatalogue loginApplication (String email,  String pass)
	{
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
		ProductCatalogue pc= new ProductCatalogue(driver);
		return pc;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		return alert.getText();
	}
}

