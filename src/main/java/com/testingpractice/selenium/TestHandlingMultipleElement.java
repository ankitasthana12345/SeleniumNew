package com.testingpractice.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingMultipleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	//	driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
		
		driver.get("https://www.wikipedia.org/");
		
		/*
		 * List<WebElement> ele=driver.findElements(By.xpath("//input"));
		 * 
		 * System.out.println(ele.size()); driver.quit();
		 */
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Eesti");

	}

}
