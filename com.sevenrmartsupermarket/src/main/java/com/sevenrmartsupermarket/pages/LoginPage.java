package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath="(//input[@class='form-control'])[1]")
	private WebElement userNameField;
	@FindBy(xpath="(//input[@class='form-control'])[2]")
	private WebElement passwordField;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	
	@FindBy(xpath="//div [@class='alert alert-danger alert-dismissible']")
	private WebElement Alert;

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); //class used to initialize elements
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
		
	}
	
	public void enterPassWord(String passWord) {
		passwordField.sendKeys(passWord);
		
		
		
	}
	public void clickOnSignIn()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.elementToBeClickable(signInButton, 60);
		signInButton.click();
		
	}
	
	public AdminUserPage login(String userName,String password )
	{
		enterUserName(userName);
		enterPassWord(password);
		clickOnSignIn();
		return new AdminUserPage(driver);
	}
	
	public AdminUserPage login() { 
		String userName=properties.getProperty("userName");
		String passWord=properties.getProperty("password");
		enterUserName(userName);
		enterPassWord(passWord);
		clickOnSignIn();
		return new AdminUserPage(driver);
	}
	public ManageContactPage login1() { 
		String userName=properties.getProperty("userName");
		String passWord=properties.getProperty("password");
		enterUserName(userName);
		enterPassWord(passWord);
		clickOnSignIn();
		return new ManageContactPage(driver);
	}

	public String get_TextOfAlert() 
	{
		String alertText=Alert.getText();
		return alertText;
	}
}
