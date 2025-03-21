package testscript;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Messages;
import pages.LoginPage;
import utilities.ExcelUtility;


public class LoginTest extends Base {
	
	@Test(priority = 1, description = " verification with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();
		boolean isDashBoardDisplayed = login.isDashBoardDisplayed();
		Assert.assertTrue(isDashBoardDisplayed, Messages.VALIDCREDENTIALERROR);
	}

	@Test(priority = 4, description = "user login verification with valid username and invalid password", groups = {
			"smoke" })
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDPASSWORDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDUSERNAMECREDENTIALERROR);

	}

	@Test(priority = 2, description = "user login with invalid credentials", dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password)
			throws IOException {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox()
				.clickOnSignInButton();
	
		boolean isTitleDisplayed = login.isTitleDisplayed();
		Assert.assertTrue(isTitleDisplayed, Messages.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin", "admin" }, new Object[] { "admin", "ad" },
				new Object[] { "admi", "admin" }, new Object[] { "adm", "adm" },
				// read from Excel
				// new Object[] {ExcelUtility.readStringData(0, 0,
				// "LoginPage"),ExcelUtility.readStringData(0, 1, "LoginPage")}

		};
	}

}