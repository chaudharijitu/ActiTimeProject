package com.Actitime.GenericLiabrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.POM.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database Connected Successfully",true);
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("Database Disconnected Successfully",true);
	}
	
	@BeforeClass
	public void LauchBrowser() throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL = f.ReadDataFromProperty("url");
		driver.get(URL);
		Reporter.log("Browser Launched",true);
	}
	
	@AfterClass
	public void CloseBrowser() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
		Reporter.log("Browser Closed",true);
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String UN = f.ReadDataFromProperty("username");
		String PW = f.ReadDataFromProperty("password");
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(2000);
		lp.getUntbx().sendKeys(UN);
		Thread.sleep(2000);
		lp.getPwtbx().sendKeys(PW);
		Thread.sleep(2000);
		lp.getLgbtn().click();
		Reporter.log("Login in Successfully",true);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Reporter.log("Log out",true);
	}
}
