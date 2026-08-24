package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.FileUtilities;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/nav/div/div[1]/div[6]/div/div/button")
	WebElement AccountButton;

	public void clickAccountButton() {
		AccountButton.click();
	}

	@FindBy (xpath = "(//button[normalize-space()='Sign in or create account'])[1]")
	WebElement SignIn;

	public void clickSignIn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//	WebElement signInBtn = wait.until(ExpectedConditions
	//			.elementToBeClickable(By.xpath("(//button[normalize-space()='Sign in or create account'])[1]")));
	//	signInBtn.click();

	}

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement enterEmail;

	public void enterEmail(String username) {
		enterEmail.click();
		this.enterEmail.sendKeys(username);
	}

	@FindBy (xpath = "//*[@id=\"password\"]")
	WebElement UsePassword;

	public void clickUsePassword() {
		UsePassword.click();
	}

	public void navLogPage(WebDriver driver) throws FileNotFoundException, IOException {
		String productionUrl = FileUtilities.readLoginPropertiesFile("production.url");
		if (productionUrl == null || productionUrl.trim().isEmpty()) {
			throw new IllegalStateException("Missing production.url in logintestdata.properties");
		}
		driver.navigate().to(productionUrl);
		logger.info("Login page deployed");
		this.clickAccountButton();
		this.clickSignIn(driver);
	}

	@FindBy(xpath = "//*[@id=\"login\"]")
	WebElement ContinueButton;

	public void clickContinueButton() {
		ContinueButton.click();
	}

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement enterPassword;

	public void enterPassword(String password) {
		this.enterPassword.sendKeys(password);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div/div/div[2]/form/button")
	WebElement SignInWithPass;

	public void clickSignInWithPass() {
		SignInWithPass.click();
	}

	public void loginToApp(WebDriver driver) throws FileNotFoundException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		this.navLogPage(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		String username = FileUtilities.readLoginPropertiesFile("valid.username");
		if (username == null || username.trim().isEmpty()) {
			throw new IllegalStateException("Missing valid.username in logintestdata.properties");
		}
		this.enterEmail(username);
		logger.info("Email entered");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
		this.clickContinueButton();
		logger.info("Continue button clicked");

		wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))); // This is reused for click
		this.clickUsePassword();
		logger.info("Use password clicked");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		String password = FileUtilities.readLoginPropertiesFile("valid.password");
		if (password == null || password.trim().isEmpty()) {
			throw new IllegalStateException("Missing valid.password in logintestdata.properties");
		}
		this.enterPassword(password);
		logger.info("Password entered");

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/button")));
		this.clickSignInWithPass();
		logger.info("Sign in with password clicked");
	}

}
