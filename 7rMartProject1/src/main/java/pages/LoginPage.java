package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// PageFactory is a class .initElements() is a method to initialize
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMeCheckbox;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashBoard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	private WebElement title;

	public LoginPage enterUsernameOnUsernameField(String username) {
		userNameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public LoginPage clickOnCheckbox() {
		PageUtility page = new PageUtility();
		page.handlingCheckbox(rememberMeCheckbox);
		return this;

	}

	public HomePage clickOnSignInButton() {
		signInButton.click();
		return new HomePage(driver);
	}

	public boolean isDashBoardDisplayed() {
		return dashBoard.isDisplayed();
	}

	public boolean isTitleDisplayed() {
		return title.isDisplayed();
	}

}