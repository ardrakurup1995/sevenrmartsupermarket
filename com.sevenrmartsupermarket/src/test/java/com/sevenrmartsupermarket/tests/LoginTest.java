package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.CaptureScreenShot;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base{
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	ExcelReader excelreader=new ExcelReader();
	
	CaptureScreenShot capturescreenshot=new CaptureScreenShot();
	@Test (retryAnalyzer=RetryAnalyzer.class,groups="smoke")
	public void verifyLoginWithValidData()
	{
		excelreader.setExcelFile("sheet2");
		excelreader.getCellData(0, 0);//returns data
		//String str=excelreader.getCellData(0, 0);
		//System.out.println(str);
		capturescreenshot.takeScreenShot(driver,"Athi");
	
	String st= GeneralUtility.get_RandomName();
	String st1= GeneralUtility.get_RandomName();
	System.out.println(st);
	System.out.println(st1);	
	
		loginpage=new LoginPage(driver);
		dashboardpage=new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		String actualProfileName=dashboardpage.getProfileName();
		String expectedProfileName="Admin";
		Assert.assertEquals(actualProfileName,expectedProfileName);
			
	}
	@Test(groups="smoke")
	public void verifyTextOfLoginAlert()
	{
		loginpage= new LoginPage(driver);
		loginpage.login("athi","0909");
		String actualTextOfAlert= loginpage.get_TextOfAlert();
		String expectedTextOfAlert="Invalid Username/Password";
		System.out.println(actualTextOfAlert);
		Assert.assertEquals(actualTextOfAlert,expectedTextOfAlert);
		
	}
	
}

