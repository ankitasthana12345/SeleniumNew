package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Test1 {
	
	@BeforeTest
	public void createDBConn() {
		System.out.println("Creat db conn");
	}
	
	@AfterTest
	public void closeDBConn() {
		System.out.println("Close db conn");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("launching browser");
	}
	
	@AfterMethod
	public void closingBrowser() {
		System.out.println("closing browser");
	}
	@Test(priority=2,groups="low")
	public void doLogin() {
		System.out.println("Executing login test");
	}
	
	@Test(priority=1,groups="high")
	public void douserReg() {
		try {
			System.out.println("Executing user sign test");
			Reporter.log("Do user reg");
			Assert.fail();
		} catch (Exception e) {
			Reporter.log("Capture ScreenShot");
			Assert.fail(e.getMessage());
		}
		
	}
	
	
}
