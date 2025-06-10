package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath="(//p[contains(text(),'Manage Contact')])[1]")
	 private WebElement managecontactinfo;
	
	@FindBy(xpath="(//a[contains(text(),'More info ')])[1]")
	 private WebElement moreInfoButton;
	
	
	@FindBy(xpath="//a[contains(text(),'New')]")
	 private WebElement newUserField;
	@FindBy(xpath="//input[@id='username']")
	 private WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")
	 private WebElement passWordField;
	@FindBy(xpath="//select[@id='user_type']")
	 private WebElement userTypeDropDown;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement saveButton;
	
	
	
	public  ManageContactPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	public void clickOnUserInfoButton()
	{
		moreInfoButton.click();
		
	}
	
	public void enterUserNameField(String userName)
	{
		userNameField.sendKeys(userName);	
	}
	public void enterPasswordField(String passWord)
	{
		passWordField.sendKeys(passWord);	
	}
	
	public void selectUserType(String text)
	{
		userTypeDropDown.click();
		PageUtility pageutility=new PageUtility(driver);
		pageutility.selectByVisibleText(userTypeDropDown, text);
		
	}
	public void ClickONsave() {
		saveButton.click();	
	}
	
	
}

