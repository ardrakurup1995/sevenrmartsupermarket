package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.sevenrmartsupermarket.dataprovider.DataProvidersMain;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUserTest extends Base {
	
	LoginPage loginpage;
	AdminUserPage adminuserpage;
	private WebDriver driver;
	@Test(groups={"smoke","regression"})
	public void validateLogin()
	{
		loginpage=new LoginPage(driver);
		
		loginpage.login();
	}
	@Test
	public void vAalidateNewUser()
	{
		loginpage= new LoginPage(driver);
		adminuserpage=loginpage.login();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickOnUserInfoButton();
		adminuserpage.verifyNewUserButton();
		boolean actualStatus=adminuserpage.verifyNewUserButton();
		System.out.println(actualStatus);
		
	}
		
@Test(dataProvider = "admin data",dataProviderClass = DataProvidersMain.class)
	public void verifyAdminUserRegistration(String userName,String passWord)
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickOnUserInfoButton();
		adminuserpage.enterUserNameField(userName);
		adminuserpage.enterPasswordField(passWord);
		adminuserpage.selectUserType("Staff");
		adminuserpage.ClickONsave();
	}



}
