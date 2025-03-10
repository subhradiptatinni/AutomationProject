package SeleniumPractice.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SeleniumPractice.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public LandingPage landingPage;
	public WebDriver driver ;
	
	public WebDriver initializeDriver() throws IOException
	{
		//chrome
//		Properties prop= new Properties();
//		
//		FileInputStream fis= new FileInputStream(System.getProperty("E://New_Java_Project//SeleniumFrameworkDesign//src//main//java//SeleniumPractice//resources//GlobalData.properties"));
//		prop.load(fis);
//		String browserName= prop.getProperty("browser");
		
//		if (browserName.equalsIgnoreCase("chrome"))
//		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
//		}
		
//		else if (browserName.equalsIgnoreCase("firefox"))
//		{
//			//firefox
//		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
		@BeforeMethod
		public LandingPage launchApplication() throws IOException
		{
			driver = initializeDriver();
			landingPage= new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
	}
		
		@AfterMethod
		public void closeBrowser()
		{
			driver.close();
		}
		
		public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
		{
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File file= new File(System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		}
		
		
		
		
		
		
						

}
