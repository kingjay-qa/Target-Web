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

	@FindBy (xpath = "//*[@id='account-sign-in']/span")
	WebElement AccountButton;

	public void clickAccountButton() {
		AccountButton.click();
	}

	@FindBy (xpath = "/html/body/div[9]/div/div/div[2]/ul/div/button")
	WebElement SignIn;

	public void clickSignIn() {
		SignIn.click();
	}

	@FindBy(xpath = "//*[@id=\"username\"]")
	WebElement enterEmail;

	public void enterEmail(String username) {
		this.enterEmail.sendKeys(username);
	}

	@FindBy (xpath = "//*[@id=\"password\"]")
	WebElement UsePassword;

	public void clickUsePassword() {
		UsePassword.click();
	}

	public void navLogPage(WebDriver driver) throws FileNotFoundException, IOException {
		driver.navigate().to(FileUtilities.readLoginPropertiesFile("production.url"));
		logger.info("Login page deployed");
		this.clickAccountButton();
		this.clickSignIn();
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

	@FindBy(xpath = "//*[@id=\"__next\"]/div/div/div/div[1]/div/div[2]/button")
	WebElement SignInWithPass;

	public void clickSignInWithPass() {
		SignInWithPass.click();
	}

	public void loginToApp(WebDriver driver) throws FileNotFoundException, IOException {
		this.navLogPage(driver);
		this.enterEmail(FileUtilities.readLoginPropertiesFile("valid.username"));
		logger.info("Email entered");
		this.clickContinueButton();
		logger.info("Continue button clicked");
		this.clickUsePassword();
		logger.info("Use password clicked");
		this.enterPassword(FileUtilities.readLoginPropertiesFile("valid.password"));
		logger.info("Password entered");
		this.clickSignInWithPass();
		logger.info("Sign in with password clicked");
	}

}
