package com.testingpractice.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPopUp { 

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://demoqa.com/browser-windows");

        System.out.println("Genrtating wind 1st window");
        Set<String> winds =driver.getWindowHandles();
        System.out.println(winds.size());
        Iterator<String> iterator = winds.iterator();
        String first_window = iterator.next();
        System.out.println(first_window);
     // Open new child window within the main window
        driver.findElement(By.id("windowButton")).click();
        driver.switchTo().window(first_window);
        System.out.println("Genrtating wind 2nd window");
        winds =driver.getWindowHandles();
        iterator = winds.iterator();
        String second_window = iterator.next();
        driver.switchTo().window(second_window);
        System.out.println(second_window);
        driver.close();
        
        
        
        
	}

}
