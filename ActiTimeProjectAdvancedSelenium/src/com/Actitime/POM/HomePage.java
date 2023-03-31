package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Decleration
	
	@FindBy(xpath = "//div[.='Tasks']")
	private WebElement taskslnk;
	
	@FindBy(xpath = "//div[.='Reports']")
	private WebElement reportslnk;
	
	@FindBy(xpath = "//div[.='Users']")
	private WebElement usersink;
	
	@FindBy(id = "logoutLink")
	private WebElement lgoutlnk;
	
	//Inilization
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	
	public WebElement getTaskslnk() {
		return taskslnk;
	}

	public WebElement getReportslnk() {
		return reportslnk;
	}

	public WebElement getUsersink() {
		return usersink;
	}

	public WebElement getLgoutlnk() {
		return lgoutlnk;
	}
	
	
}
	