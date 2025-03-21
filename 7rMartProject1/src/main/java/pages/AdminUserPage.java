	package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUserField;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUsersField;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newUserField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adminUsernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adminPasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeField;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchUserField;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchUsername;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//a[text()=' Reset']")
	private WebElement resetButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement newUserAlert;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	private WebElement subTitleOfSearchAdminUserPage;
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement titleOfAdminUsersResetPage;

	public HomePage clickOnAdminUserField() {
		adminUserField.click();
		return new HomePage(driver);
	}

	public AdminUserPage clickOnManageUserField() {
		manageUsersField.click();
		return new AdminUserPage(driver);
	}

	public AdminUserPage clickOnNewUserField() {
		newUserField.click();
		return this;
	}

	public AdminUserPage enterAdminUsernameOnUsernameField(String adminUsername) {
		adminUsernameField.sendKeys(adminUsername);
		return this;
	}

	public AdminUserPage enterAdminPasswordOnPasswordField(String adminPassword) {
		adminPasswordField.sendKeys(adminPassword);
		return this;
	}

	public AdminUserPage selectUserTypeOnUserTypeField() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithValue(userTypeField, "staff");
		return this;
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public AdminUserPage clickOnSearchuserField() {
		searchUserField.click();
		return this;
	}

	public AdminUserPage enterAdminUsernameToSearch(String adminUsername) {
		searchUsername.sendKeys(adminUsername);
		return this;
	}

	public AdminUserPage selectTheUserTypeToSearch() {
		Select select = new Select(searchUserType);
		select.selectByVisibleText(Constants.ADMINUSERDROPDOWNVALUE);
		return this;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public AdminUserPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	public String getTextFromNewUserAlert() {
		return newUserAlert.getText();
	}

	public boolean isSubTitleOfSearchAdminUserPageIsDisplayed() {
		return subTitleOfSearchAdminUserPage.isDisplayed();
	}

	public boolean isTitleDisplayedOnAdminUsersResetPage() {
		return titleOfAdminUsersResetPage.isDisplayed();
	}

}