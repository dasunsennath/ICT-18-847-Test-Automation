package com.hr.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hr.qa.base.TestBase;
import com.hr.qa.pages.HomePage;
import com.hr.qa.pages.LoginPage;
import com.hr.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	String SheetName  = "Users";
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =  new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest(){
		boolean logo = loginPage.validateActiTimeLogoImage();
		Assert.assertTrue(logo);
	}
	
	@DataProvider
	public Object [][] GetUserTestData()
	{
	   Object [][] data = 	TestUtil.getTestData(SheetName);
	   return data;
	}
	
	@Test(priority = 3,dataProvider = "GetUserTestData")
	public void loginTest(String Username,String Password) {
		homepage = loginPage.login(Username, Password);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
