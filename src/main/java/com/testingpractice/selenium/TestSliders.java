package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		WebElement mainslider = driver.findElement(By.xpath("//*[@id='slider']"));
		int width = (mainslider.getSize().width)/8;
		
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider,width, 0).build().perform();
		
	}

}
