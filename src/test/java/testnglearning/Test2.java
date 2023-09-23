package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test2 {

	@Test
	public void validateTitle() {
		SoftAssert softassert = new SoftAssert();
		System.out.println("Begging");
		String actual_title ="Gmail.com";
		String expected_title="Gmails.com"; 
		softassert.assertEquals(actual_title, expected_title,"Title are not matching");
		softassert.assertTrue(false, "Element not found");
		softassert.fail("Forcefully failing test cases");
		System.out.println("Ending");
		softassert.assertAll();
	}


}
