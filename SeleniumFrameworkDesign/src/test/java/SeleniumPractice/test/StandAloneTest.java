package SeleniumPractice.test;

import java.time.Duration;
import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumPractice.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productname= "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		Thread.sleep(100);
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("subhradipta.tinni@gmail.com", "Qwerty@123");
//		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("subhradipta.tinni@gmail.com");
//		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Qwerty@123");
//		driver.findElement(By.xpath("//input[@id='login']")).click();
	
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".mb-3"))));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod= products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
		List<WebElement> cartProd= driver.findElements(By.xpath("//*[@class='cartSection']/ h3"));
		Boolean match= cartProd.stream().anyMatch(cp->
		cp.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		
		driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirm= driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirm.equalsIgnoreCase(" Thankyou for the order."));
		}

}
