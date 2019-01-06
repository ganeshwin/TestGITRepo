package com.CRM.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CRM.TestBase.base;
import com.CRM.TestUtil.util;


public class LoginPage extends base{

	@FindBy(xpath="//*[@id=\'loginForm\']/div/input[1]")
	WebElement signinname;
	@FindBy (css="#loginForm > div > input:nth-child(2)")
	WebElement signinpassword;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	
	//initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void validateloginpagetitle() {
		String ActualTitle = "Free CRM in the cloud software boosts sales";
		String ExpectedTitle = "";
		ExpectedTitle = driver.getTitle();
		//String ExpectedTitle = driver.getTitle();  -- u can write like this
		
		if(ActualTitle.contentEquals(ExpectedTitle)) {
			System.out.println("Loginpage Title is correct");
		} else {
			System.out.println("Loginpage Title is incorrect");
		}
	}
		
	public void login(String sname, String pwd) throws InterruptedException {
		signinname.sendKeys(sname);
		signinpassword.sendKeys(pwd);
		Thread.sleep(1000);
		signinpassword.sendKeys(Keys.TAB);
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
	
*/		
		Actions actions = new Actions(driver);
	//	actions.moveToElement(loginbtn).build().perform();
		actions.moveToElement(loginbtn).doubleClick(loginbtn).build().perform();
		
		//return new HomePage();
		
		/*loginbtn.click();*/
		String ActualTitle = "CRMPRO";
		String ExpectedTitle = driver.getTitle();
		
		driver.manage().timeouts().pageLoadTimeout(util.page_load_time,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.implicit_time, TimeUnit.SECONDS);
		
		if(ActualTitle.contentEquals(ExpectedTitle)) {
			System.out.println("Loggedin Successfully");
		} else {
			System.out.println("Not Loggedin Successfully");
		}
		
		} 
}
	