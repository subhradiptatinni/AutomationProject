package SeleniumPractice.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//*[@class='cartSection']/ h3")
	List<WebElement> cartProd;
	
	@FindBy(xpath= "//button[normalize-space()='Checkout']")
	WebElement checkOut;
	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match= cartProd.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productName));	
		return match;
	}
	
	public checkOutPage goToCheckOut()
	{
		checkOut.click();
		checkOutPage check= new checkOutPage(driver);
		return check;
	}
}

//List<WebElement> cartProd= driver.findElements(By.xpath("//*[@class='cartSection']/ h3"));
//Boolean match= caProd.stream().anyMatch(cp->
//cp.getText().equalsIgnoreCase(productname));