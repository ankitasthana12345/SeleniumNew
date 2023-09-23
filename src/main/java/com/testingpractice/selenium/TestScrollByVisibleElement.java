package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScrollByVisibleElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://demo.guru99.com/test/guru99home/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

		//Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.linkText("JAVA"));
        Thread.sleep(3000);
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);

	}

}
