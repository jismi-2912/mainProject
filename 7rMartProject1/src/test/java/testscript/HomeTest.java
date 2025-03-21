package testscript;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends Base{
	@Test(description = "verification of user can log out from the home page", retryAnalyzer = retry.ReTry.class)
	public void verifyWhetherUserCanLogOutFromHomePageAfterLoginToThePage() throws IOException {
		HomePage home;

		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		home.clickOnAdminField();
		login = home.clickOnLogOutField();
		boolean isSignButtonEnabled = home.isSignInButtonEnabled();
		Assert.assertTrue(isSignButtonEnabled, Messages.LOGOUTFROMHOMEPAGEERROR);
	}

}