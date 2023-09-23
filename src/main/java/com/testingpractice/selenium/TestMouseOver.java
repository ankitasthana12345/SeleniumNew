package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.way2automation.com/");
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu-item-27580\"]/a/span[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu-item-27581\"]")).click();
		

	}

}
