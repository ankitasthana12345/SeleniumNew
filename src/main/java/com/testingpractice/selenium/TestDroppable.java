package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDroppable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		/*
		 * WebElement droppable = driver.findElement(By.
		 * xpath("//div[@style='position: relative; left: 652px; top: 51px;']"));
		 * 
		 * Actions action = new Actions(driver); action.dragAndDrop(draggable,
		 * droppable).build().perform();
		 */
        Dimension currentDimension = driver.manage().window().getSize();
        int ht = currentDimension.height/2;
        int wd = currentDimension.width/4;
       /* int x = draggable.getLocation().x;
        int y = draggable.getLocation().y;
        x=x+100;
        y=y+200;*/
        
        Actions action = new Actions(driver);
        action.dragAndDropBy(draggable, ht, wd).build().perform();
		
		

	}

}
