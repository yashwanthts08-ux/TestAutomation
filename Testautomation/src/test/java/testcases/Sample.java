package testcases;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import base.BaseTest;
import driverfactory.DriverFactory;
import utilities.ReadXlsData;

public class Sample extends BaseTest {
	
	
@Test(dataProviderClass=ReadXlsData.class ,dataProvider="bvtdata")

public void search(String searching,String sample) {
	DriverFactory.getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(searching);
	DriverFactory.getDriver().findElement(By.xpath("//input[@name='pass']")).sendKeys(sample);
	
	
	

}

}
