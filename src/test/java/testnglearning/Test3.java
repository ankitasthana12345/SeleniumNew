package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test3 {

	@Test(priority=2,dependsOnMethods="douserReg")
	public void doLogin() {
		System.out.println("Executing login test");
	}

	@Test(priority=1,groups= {"high","med"})
	public void douserReg() {
		System.out.println("Executing user sign test");
	//	Assert.fail("Failing user Reg");
	}

	@Test(priority=3)
	public void isSkip() {
     throw new SkipException("Skipping the test condition not matcch");
	}
}
