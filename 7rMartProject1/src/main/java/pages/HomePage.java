package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	private WebElement adminField;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logOutField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SignInButton;
	@FindBy(xpath = "//a[@class=' nav-link']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNewsField;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUserField;
	@FindBy(xpath = "//p[text()='Manage Users']")
	private WebElement manageUsersField;

	public HomePage clickOnAdminField() {
		adminField.click();
		return this;
	}

	public LoginPage clickOnLogOutField() {
		logOutField.click();
		return new LoginPage(driver);
	}

	public SubCategoryPage clickOnSubCategoryField() {
		subCategoryField.click();
		return new SubCategoryPage(driver);
	}

	public ManageNewsPage clickOnManageNewsField() {
		manageNewsField.click();
		return new ManageNewsPage(driver);
	}

	public HomePage clickOnAdminUserField() {
		adminUserField.click();
		return new HomePage(driver);
	}

	public AdminUserPage clickOnManageUserField() {
		manageUsersField.click();
		return new AdminUserPage(driver);
	}

	public boolean isSignInButtonEnabled() {
		return SignInButton.isEnabled();
	}

}