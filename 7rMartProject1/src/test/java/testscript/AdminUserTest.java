package testscript;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import automation_core.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;



public class AdminUserTest extends Base {

	@Test(priority = 1, description = "verification of user can enter new  admin users informations by clicking New button")
	public void verifyWhetherUserIsAbleToAddNewUsersToUsersList() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		home.clickOnAdminUserField();
		FakerUtility faker = new FakerUtility();
		String adminUsername = faker.createRandomUsername();
		String adminPassword = faker.createRandomPassword();
		AdminUserPage adminUser1 = home.clickOnManageUserField();
		adminUser1.clickOnNewUserField().enterAdminUsernameOnUsernameField(adminUsername)
				.enterAdminPasswordOnPasswordField(adminPassword).selectUserTypeOnUserTypeField().clickOnSaveButton();

		String expectedResult = "Alert!";
		String actualResult = adminUser1.getTextFromNewUserAlert();
		Assert.assertEquals(actualResult, expectedResult, Messages.ADDNEWUSERERROR);

	}

	@Test(priority = 2, description = "verification of user can search admin users in AdminUsers list by clicking Search button")
	public void verifyWhetherUsersIsAbleToSearchNewlyAddedUsersInTheNewlyAddedUsersList() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		home.clickOnAdminUserField();
		AdminUserPage adminUser1 = home.clickOnManageUserField();
		String adminUserName = ExcelUtility.readStringData(1, 0, "AdminUsersPage");
		adminUser1.clickOnSearchuserField().enterAdminUsernameToSearch(adminUserName).selectTheUserTypeToSearch()
				.clickOnSearchButton();
		boolean isSubTitleOfSearchAdminUserPageDisplayed = adminUser1.isSubTitleOfSearchAdminUserPageIsDisplayed();
		Assert.assertTrue(isSubTitleOfSearchAdminUserPageDisplayed, Messages.SEARCHNEWUSERERROR);

	}

	@Test(priority = 3, description = "verification of user can refresh AdminUsers page by clicking Reset button")
	public void verifyUsersIsAbleToRefreshNewlyAddedUsersPageUsingResetButton() throws IOException {
		HomePage home;
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");

		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnCheckbox();
		home = login.clickOnSignInButton();
		home.clickOnAdminUserField();
		AdminUserPage adminUser1 = home.clickOnManageUserField();
		adminUser1.clickOnResetButton();
		boolean isTitleDisplayedOnAdminUsersResetPage = adminUser1.isTitleDisplayedOnAdminUsersResetPage();
		Assert.assertTrue(isTitleDisplayedOnAdminUsersResetPage, Messages.REFRESHADMINUSERPAGEERROR);

	}

}