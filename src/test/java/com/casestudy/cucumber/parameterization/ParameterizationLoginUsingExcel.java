package com.casestudy.cucumber.parameterization;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.casestudy.cucumber.pagebean.LoginPageFactory;
import au.com.bytecode.opencsv.CSVReader;
import com.casestudy.cucumber.setup.*;

public class ParameterizationLoginUsingExcel {    // DO NOT CHANGE CLASS NAME
	
	// Use the below declared variables
	public WebDriver driver;
	public LoginPageFactory loginpf;

//	public static XSSFSheet worksheet;
//    public static XSSFWorkbook workbook;
//    public static FileInputStream work_file;
//    public static String file_path;

	public ParameterizationLoginUsingExcel() {}
	
	public ParameterizationLoginUsingExcel(WebDriver driver) {
		this.driver=driver;
	}
	
	// Implement code here
	
	public static String[] readExcelData(String filename, String sheetName) throws Exception {   //Do not change the method signature

		FileInputStream work_file=new FileInputStream(filename);
		XSSFWorkbook workbook=new XSSFWorkbook(work_file);
		XSSFSheet worksheet=workbook.getSheet(sheetName);
        		

        XSSFRow row=worksheet.getRow(0);
        XSSFCell cell = null;
        
        	
        String[] user_data=new String[2];
        for(int i=0;i<2;i++)
        {
            switch(row.getCell(i).getCellType())
        	{
        			case STRING:
        			    user_data[i]=row.getCell(i).getStringCellValue();
        			break;
                    case NUMERIC:
                        user_data[i]=row.getCell(i).getNumericCellValue()+"";
        			break;
            		case BLANK:
        	       		user_data[i]=null;
                    break;
        	}
        			
        	System.out.println(user_data[i]);
        
        }
        	
        return user_data;
        	
    }
	
	@BeforeTest
	public void setUp() throws Exception {
		driver= DriverSetup.getDriver();
		driver.get("https://webapps.tekstac.com/SeleniumApp1/SmartUniversity/login.html");
		loginpf=new LoginPageFactory(driver);
	}
	
	
	@Test
	public void testLoginPage() throws Exception {
		
		String[] values=readExcelData("cucumberproject\\src\\test\\java\\com\\casestudy\\cucumber\\invalidSignIn.xlsx", "invalidSignIn");

  			String username=values[0];	
			String password=values[1];
			
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);			
			String captcode = driver.findElement(By.id("result")).getText();			
			driver.findElement(By.id("captcha")).sendKeys(captcode);		
			driver.findElement(By.id("submit")).click();
			
			String errmsg = driver.findElement(By.id("passwordError")).getText();

		}
		
	
	
	@AfterTest
	public void close(){
		// code to close the driver
//		driver.close();
	}

}
	 	  	  		 	     	     	      	 	
