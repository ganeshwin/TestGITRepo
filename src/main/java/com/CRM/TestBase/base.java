package com.CRM.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.CRM.TestUtil.util;

public class base {
	
	protected static Properties prop;
	protected static WebDriver driver;
	
	public base() {
		try {
		prop = new Properties();
		FileInputStream ip;
		ip = new FileInputStream("D:\\Automation\\FreeCRMTest\\src\\main\\java\\com\\CRM\\TestConfig\\config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}		
		public static void initialization() {
		
		String Browsername = prop.getProperty("browser");
		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Browsername.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "D:\\geckohromedriver_win32\\gecko.exe");
		}else if(Browsername.equals("safari")) {
			System.setProperty("webdriver.safari.driver", "D:\\safaridriver_win32\\safari.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.implicit_time, TimeUnit.SECONDS);
		driver.navigate().to(prop.getProperty("url"));
	}

}