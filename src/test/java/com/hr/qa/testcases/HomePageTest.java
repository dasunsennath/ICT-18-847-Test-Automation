package com.hr.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hr.qa.base.TestBase;
import com.hr.qa.pages.HomePage;
import com.hr.qa.pages.LoginPage;
import com.hr.qa.pages.ReportPage;
import com.hr.qa.pages.TaskPage;
import com.hr.qa.pages.UsersPage;


public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	TaskPage taskpage;
	ReportPage reportPage;
	UsersPage userPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =  new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority = 1)
	public void homePageTaskLinkTest() {
		taskpage = homePage.ClickOnTaskLink();
	}
	
	@Test(priority = 2)
	public void homePageReportLinkTest() {
		reportPage = homePage.ClickOnReportsLink();
	}
	
	@Test(priority = 3)
	public void homePageUserLinkTest() {
		userPage = homePage.ClickOnUsersLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
