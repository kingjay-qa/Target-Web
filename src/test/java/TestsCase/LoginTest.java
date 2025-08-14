package TestsCase;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.Listening;
import Pages.LoginPage;

@Listeners(Listening.class)

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() throws FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		logger.info("Browser instance launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(driver);
		logger.info(driver.getTitle());
		System.out.println("The first testcase is complete");
	}
	
}
