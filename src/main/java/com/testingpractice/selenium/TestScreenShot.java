package com.testingpractice.selenium;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenShot {
	
	public static WebDriver driver;
	
	public static void captureScreenShot() throws IOException {
		
		Date date = new Date(System.currentTimeMillis());
		String filename=date.toString().replace("-", "_")+".jpg";
		TakesScreenshot takescrshot = ((TakesScreenshot)driver);
		File screenshot = takescrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"\\screenshot\\"+filename));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://demo.guru99.com/test/guru99home/");
		Thread.sleep(1000);
		captureScreenShot();
		

	}

}
