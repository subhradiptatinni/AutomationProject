package SeleniumPractice.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumPractice.TestComponent.BaseTest;
import SeleniumPractice.TestComponent.Retry;

public class ErrorValidationTest extends BaseTest{
	
	@Test(groups = {"Errorhanding"}, retryAnalyzer= Retry.class)
	public void LoginErrorvalidation() throws IOException, InterruptedException {
		
		landingPage.loginApplication("subhradipta.tinni@gmai.com", "Qwerty@123");
		Assert.assertEquals("Incorrect email password", landingPage.getErrorMessage());
	}

}
