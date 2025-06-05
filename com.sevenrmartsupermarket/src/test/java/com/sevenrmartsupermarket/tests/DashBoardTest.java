package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardTest {
WebDriver driver;

@FindBy(xpath="//a[@class='d-block']")
WebElement profileNameElement;
	public void DashBoardPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);// class used to initilalize elements
		
	}
	
	public String getProfileName() 
	{
		return profileNameElement.getText();
	}
}
