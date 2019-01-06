package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.TestBase.base;

public class HomePage extends base{
	
	@FindBy(xpath="//td[contains(text(),'User: Ganesh Soundaran')]")
	WebElement usernamelabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}	
	
	
	public String verifyhomepage() {
		return driver.getTitle();
	}
	public ContactsPage clickoncontactslink() {
		contactslink.click();
		return new ContactsPage(); 
	}
	public DealsPage clickondealslink() {
		dealslink.click();
		return new DealsPage(); 
	}	
	public TaskPage clickontaskslink() {
		taskslink.click();
		return new TaskPage(); 
	}	

}
