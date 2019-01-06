package com.CRM.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CRM.Pages.HomePage;
import com.CRM.Pages.LoginPage;
import com.CRM.TestBase.base;

public class LoginTest1 extends base{
	
	
	LoginPage login;
	
	public LoginTest1(){
		super();
		}
	
	@BeforeTest
	public void setup() {
		base.initialization();	
		login = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginpagetitletest() 
	{
		login.validateloginpagetitle();
		}
	
	@Test(priority=2)
	public void loginpagetest() throws InterruptedException {
		login.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
