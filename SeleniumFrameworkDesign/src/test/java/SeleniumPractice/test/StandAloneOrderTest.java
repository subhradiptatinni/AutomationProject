package SeleniumPractice.test;

import java.time.Duration;
import java.util.List;

//import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;

import SeleniumPractice.pageobjects.LandingPage;
import SeleniumPractice.pageobjects.ProductCatalogue;
import SeleniumPractice.pageobjects.cartPage;
import SeleniumPractice.pageobjects.checkOutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import SeleniumPractice.TestComponent.*;

public class StandAloneOrderTest extends BaseTest {

	
	String productname= "ADIDAS ORIGINAL";
	String countryName= "India";
	
//	@Test
//	public void login()
//	{
//		landingPage.loginApplication("subhradipta.tinni@gmail.com", "Qwerty@123");
//
//		
//	}
	
		@Test
		public void OrderProduct()
		{
		ProductCatalogue pc= landingPage.loginApplication("subhradipta.tinni@gmail.com", "Qwerty@123");
		List<WebElement>products= pc.getProductList();
		pc.addProductToCart(productname);	
		cartPage cpage= pc.goToCartPage();
		Assert.assertTrue(cpage.VerifyProductDisplay(productname));
		checkOutPage check= cpage.goToCheckOut();
		check.selectCountry(countryName);
		}


		
	
		
		
		
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector(".action__submit")).click();
//		String confirm= driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirm.equalsIgnoreCase(" Thankyou for the order."));
		}



	


