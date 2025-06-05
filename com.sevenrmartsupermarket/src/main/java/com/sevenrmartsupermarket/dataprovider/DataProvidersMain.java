package com.sevenrmartsupermarket.dataprovider;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProvidersMain {
	
	ExcelReader excel=new ExcelReader();
	
	@DataProvider(name = "admin ")
    public Object[][] getData() {
      excel.setExcelFile("DataProviders"); 
      return excel.getMultidimentionalData(3, 2);
          
	
          
	}
	
	

	}

