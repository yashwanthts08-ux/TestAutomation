package testcases;

import retry.RetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import driverfactory.DriverFactory;
import pages.LoginPage;

public class SecondSample extends BaseTest {
@Test(retryAnalyzer = RetryAnalyzer.class) // we can add in listener class as well if we want to do it for all failed cases
void LoginTest() {
	SoftAssert soft = new SoftAssert();
	LoginPage lp=new LoginPage(DriverFactory.getDriver());
	lp.setUsername(p.getProperty("email"));
	lp.setPassword(p.getProperty("pass"));
	Assert.assertEquals(lp.title(), "Facebook");
	soft.assertEquals(lp.title(),"Facebook");
	soft.assertAll();
}

}
