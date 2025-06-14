package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public String get_attribute(WebElement element, String attributer)
	{
		return element.getAttribute(attributer);
	}
 
	public  String get_cssvalue(WebElement element, String cssvalue)
	{
		return element.getCssValue(cssvalue);
	}
	
	public List<String> get_textofElements(List<WebElement> elements)
	{
		List<String> data=new ArrayList<String>();
		for(WebElement element:elements) {
			data.add(element.getText());
		}
		
	return data;
	}
	
	public static String get_RandomName() {//generate ran
		Faker faker=new Faker();
		return faker.name().firstName();
	}
	
	public static String get_TimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
	}


