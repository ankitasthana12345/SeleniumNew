package testnglearning;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsReporter {
   
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentSparkReporter("./reports/extentreport.html"); 
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automatio Report");
		htmlReporter.config().setReportName("Automation Result");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@AfterTest
	public void endReport() {
		extent.flush();
		
	}
	
	@Test
	public void doLogin() {
		test = extent.createTest("Login Test");
		test.info("Do login test");
	}
	
	@Test
	public void doUserReg() {
		test = extent.createTest("Do user Reg Test");
		test.log(Status.INFO, "Enter User Name");
		test.log(Status.INFO, "Enter Password");
		test.log(Status.FAIL, "Failing the test-screen shot attached");
		Assert.fail("Failing user reg Test");
	}
	
	@Test
	public void validateTitle() {
		test = extent.createTest("Validating title Test");
		throw new SkipException("Skipping tets cases");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String expectionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			String screenshot = "C:\\Users\\ankit\\OneDrive\\Desktop\\Screenshot 2022-06-13 210104.png";
			test.fail( MediaEntityBuilder.createScreenCaptureFromPath(screenshot, "Screen pic").build());
			String tc = result.getMethod().getMethodName().toString();
			test.fail(expectionMessage);
			test.log(Status.FAIL, "Failed Test "+tc.toUpperCase());
			
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Passed Test");
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test");
		}
		
	}
}
