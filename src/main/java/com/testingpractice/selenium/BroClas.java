package com.testingpractice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;

public class BroClas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle().length());
		driver.close();
		driver.quit();
		
		

	}

}
