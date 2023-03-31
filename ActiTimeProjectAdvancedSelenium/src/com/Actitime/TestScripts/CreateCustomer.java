package com.Actitime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.Actitime.GenericLiabrary.BaseClass;
import com.Actitime.GenericLiabrary.FileLibrary;
import com.Actitime.POM.HomePage;
import com.Actitime.POM.TaskPage;

public class CreateCustomer extends BaseClass{
	@Test
	public void CreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.getTaskslnk().click();
		
		TaskPage tp=new TaskPage(driver);
		Thread.sleep(2000);
		tp.getAddnewbtn().click();
		Thread.sleep(2000);
		tp.getNewcust().click();;
		
		FileLibrary f=new FileLibrary();
		String name = f.ReadDataFromExcelFile("Sheet1", 4, 1);
		Thread.sleep(2000);
		tp.getCustname().sendKeys(name);
		
		String description = f.ReadDataFromExcelFile("Sheet1", 4, 2);
		Thread.sleep(2000);
		tp.getCustdesp().sendKeys(description);
		
		Thread.sleep(2000);
		tp.getCreatecust().click();
}
}
