package testscript;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNews extends Base{

	@Test(priority = 1, description = "verification of user can enter news in ManageNews by clicking New button")
	public void verifyWhetherUserCanEnterNewNewsInformationsInManageNewsField() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		ManageNewsPage manageNews = home.clickOnManageNewsField();
		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		manageNews.clickOnNewField().enterTheNewsOnNewsField(news).clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = manageNews.getTextFromAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.CREATENEWNEWSERROR);

	}

	@Test(priority = 2, description = "verification of user can search news in ManageNews by clicking Search button ")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNewsInManageNewsField() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		ManageNewsPage manageNews = home.clickOnManageNewsField();
		String news = ExcelUtility.readStringData(1, 0, "ManageNewsPage");
		manageNews.clickOnSearchField().enterTheNewsToSearch(news).clickOnSearchButton();
		boolean isSubTitleOfSearchManageNewsDisplayed = manageNews.isSubTitleOfSearchManageNewsPageDisplayed();
		Assert.assertTrue(isSubTitleOfSearchManageNewsDisplayed, Messages.SEARCHNEWSERROR);

	}

	@Test(priority = 3, description = "verification of user can refresh ManageNews page by clicking Reset  button")
	public void verifyWhetherUserIsAbleToRefreshManageNewsPageUsingResetButton() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		ManageNewsPage manageNews = home.clickOnManageNewsField();
		manageNews.clickOnResetButton();
		/*login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnCheckbox();
		login.clickOnSignInButton();

		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnManageNewsField();
		manageNews.clickOnResetButton();*/

		boolean isTitleOfManageNewsResetPageDisplayed = manageNews.isTitleOfManageNewsResetPageDisplayed();
		Assert.assertTrue(isTitleOfManageNewsResetPageDisplayed, Messages.REFRESHMANAGENEWSPAGEERROR);

	}

}