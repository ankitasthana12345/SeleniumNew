package testnglearning;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameter {

	@DataProvider(name="dp")
	public Object[][] getData(){
		return new Object[][] {
			{"Name","Ankit"},
			{"Name","Sunil"}
		};
		
	}
	
	
	@Test(dataProvider="dp")
	public void doLogin(String username,String password) {
		System.out.println(username+"------"+password);
	}
}
