package testscript;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base
{
	@Test(priority = 1, description = "verification of user can enter new subcategory informations to SubCategory list by clicking New button")
	public void verifyWhetherUserIsAbleToAddNewSubCategoryItemsToSubCategoryList() throws IOException {

		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		SubCategoryPage subCategory = home.clickOnSubCategoryField();

		String subcategoryText = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		subCategory.clickOnNewField().selectCategoryFromCategoryField()
				.enterSubCategoryTextOnSubCategoryfield(subcategoryText).chooseFileOnImageField().clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = subCategory.getTextFromSubcategoryAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.ADDNEWITEMTOSUBCATEGORYERROR);

	}

	@Test(priority = 2, description = "verification of user can search subcategory details from SubCategory list by clicking Search button")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedSubCategoryItemsFromSubCategoryList() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		SubCategoryPage subCategory = home.clickOnSubCategoryField();
		String subcategoryData = ExcelUtility.readStringData(1, 0, "SubCategoryPage");
		subCategory.clickOnSearchField().selectCategoryToSearch().enterSubCategoryTextToSearch(subcategoryData)
				.clickOnSearchButton();
		boolean isSubTitleDisplayed = subCategory.isSubTitleDisplayedOnSearchSubCategoryPage();
		Assert.assertTrue(isSubTitleDisplayed, Messages.SEARCHITEMINSUBCATEGORYERROR);

	}

	@Test(priority = 3, description = "verification of user can refresh subcategory page by clicking reset button")
	public void verifyWhetherUserIsAbleToRefreshSubCategoryPageUsingResetButton() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		SubCategoryPage subCategory = home.clickOnSubCategoryField();
		subCategory.clickOnResetButton();
		boolean isTitleDisplayedOnResetPage = subCategory.isTitleDisplayedOnResetPage();
		Assert.assertTrue(isTitleDisplayedOnResetPage, Messages.REFRESHSUBCATEGORYPAGEERROR);

	}

}