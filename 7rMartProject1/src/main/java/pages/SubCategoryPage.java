package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class SubCategoryPage {

	public WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class=' nav-link']")
	private WebElement subCategoryField;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newfield;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement selectCategoryField;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryText;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchfield;
	@FindBy(xpath = "//select[@id='un']")
	private WebElement selectField;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement searchSubCategorytext;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement addSubcatecoryAlert;
	@FindBy(xpath = "//h4[text()='Search List Sub Categories']")
	private WebElement subTitle;
	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement titleOfResetPage;

	public SubCategoryPage clickOnSubCategoryField() {
		subCategoryField.click();
		return new SubCategoryPage(driver);
	}

	public SubCategoryPage clickOnNewField() {
		newfield.click();
		return this;

	}

	public SubCategoryPage selectCategoryFromCategoryField() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(selectCategoryField, 4);
		return this;
	}

	public SubCategoryPage enterSubCategoryTextOnSubCategoryfield(String subcategoryText) {
		subCategoryText.sendKeys(subcategoryText);
		return this;

	}

	public SubCategoryPage chooseFileOnImageField() {
		imageUpload.sendKeys(Constants.IMAGEFILE);
		return this;
	}

	public void clickOnSaveButton() {
		saveButton.submit();
	}

	public SubCategoryPage clickOnSearchField() {
		searchfield.click();
		return this;
	}

	public SubCategoryPage selectCategoryToSearch() {
		PageUtility page = new PageUtility();
		page.selectDropdownWithIndex(selectField, 5);
		return this;

	}

	public SubCategoryPage enterSubCategoryTextToSearch(String subcategoryData) {
		searchSubCategorytext.sendKeys(subcategoryData);
		return this;
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnResetButton() {
		resetButton.click();

	}

	public String getTextFromSubcategoryAlert() {
		return addSubcatecoryAlert.getText();
	}

	public boolean isSubTitleDisplayedOnSearchSubCategoryPage() {
		return subTitle.isDisplayed();
	}

	public boolean isTitleDisplayedOnResetPage() {
		return titleOfResetPage.isDisplayed();
	}

}