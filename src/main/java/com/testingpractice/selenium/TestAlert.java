package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlert {
    public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		/*
		 * driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 * driver.findElement(By.name("proceed")).click();
		 * 
		 * Alert alert = driver.switchTo().alert(); System.out.println(alert.getText());
		 * Thread.sleep(3000); alert.accept();
		 */
		
		driver.get("https://username:password@mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		

	}

}
