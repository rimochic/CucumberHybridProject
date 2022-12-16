package Base;




import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.loginObjects;
import Utilities.readConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	readConfig rc = new readConfig();
	String browser = rc.getBrowser();
	public static WebDriver driver;
	public static loginObjects lp;
	public Logger log;
	
	@BeforeClass
	public void launchBrowser() {
		
		log = LogManager.getLogger("Login");
		PropertyConfigurator.configure("./Configurations/log4j.properties");
		
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
