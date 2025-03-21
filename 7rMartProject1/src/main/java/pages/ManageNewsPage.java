package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNewsField;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newfield;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNewsfield;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchField;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchNewsText;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement newNewsAlert;
	@FindBy(xpath = "//h4[text()='Search Manage News']")
	private WebElement subtitleOfSearchManageNewsPage;
	@FindBy(xpath = "//h1[text()='Manage News']")
	private WebElement titleOfResetPage;

	public ManageNewsPage clickOnManageNewsField() {
		manageNewsField.click();
		return new ManageNewsPage(driver);
	}

	public ManageNewsPage clickOnNewField() {
		newfield.click();
		return this;
	}

	public ManageNewsPage enterTheNewsOnNewsField(String news) {
		enterNewsfield.sendKeys(news);
		return this;
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public ManageNewsPage clickOnSearchField() {
		searchField.click();
		return this;
	}

	public ManageNewsPage enterTheNewsToSearch(String news) {
		searchNewsText.sendKeys(news);
		return this;
	}

	public void clickOnSearchButton() {
		searchButton.click();

	}

	public ManageNewsPage clickOnResetButton() {
		resetButton.click();
		return this;
	}

	public String getTextFromAlert() {
		return newNewsAlert.getText();
	}

	public boolean isSubTitleOfSearchManageNewsPageDisplayed() {
		return subtitleOfSearchManageNewsPage.isDisplayed();
	}

	public boolean isTitleOfManageNewsResetPageDisplayed() {
		return titleOfResetPage.isDisplayed();
	}

}