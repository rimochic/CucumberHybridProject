package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Assert;

import Base.BaseClass;
import PageObjects.loginObjects;
import Utilities.xlutil;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClass{
	
	
	
	@Given("User Launch browser")
	public void user_launch_browser() {
	   launchBrowser();
	   log.info("Browser Launched");
	}

	@When("opens URL {string}")
	public void opens_url(String url) {
		driver.get(url);
		log.info("URL opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		lp = new loginObjects(driver);
	   lp.setUserName(email);
	   log.info("Email entered");
	   lp.setPassword(pwd);
	   log.info("Password entered");
	   
	}

	@And("Click on Login button")
	public void click_on_login_button() throws InterruptedException {
		lp.BtnClick();
		Thread.sleep(2000);
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() throws IOException {
		if(driver.getPageSource().contains("You are successfully logged in.")) {
			Assert.assertTrue(true);
			
			log.info("User Successfully loged in.. Test Passed..");
			lp.logoutClick();
		}
		else {
			
			log.warn("Test Failed...!!!");
			driver.close();;
			Assert.assertTrue(false);
			
		}
	}

	@And("User close the browser")
	public void user_close_the_browser() {
		log.info("Browser Closed");
		tearDown();
	}	
	
	@After
	public void getScreenshot(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replace(" ", " ");
			byte [] srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(srcPath, "Image.png", screenshotName);
			
		}
	 }
	
	
	@And("User enters Email and Password from Excel file {string}")
	public void user_enters_email_and_password_from_excel_file(String rows) throws IOException {
		xlutil xl = new xlutil();
		String path = "./Data/dataFile.xlsx";
		int index = Integer.parseInt(rows)-1;
		List<HashMap<String, String>> getData = new ArrayList<>();
		getData = xl.getDataExcel(path, "Sheet1");
		
		lp = new loginObjects(driver);
		   lp.setUserName(getData.get(index).get("User"));
		   log.info("Email entered");
		   lp.setPassword(getData.get(index).get("Password"));
		   log.info("Password entered");
	}

}
