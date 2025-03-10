package SeleniumPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPractice.AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent{
	
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class,'action__submit')]")
	WebElement checkButton;
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath= "//button[contains(@class,'ta-item')][2]")
	WebElement choose;
	
	By box= By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	public void selectCountry(String countryName)
	{
		
		country.sendKeys(countryName);
		waitForElementToAppear(box);
		choose.click();
		//checkButton.click();
		
	}

}
