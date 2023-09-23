package com.testingpractice.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckBoxes {
	
public static WebDriver driver;
public static boolean isElementPresent(By by) {
		
		/*
		 * try {
		 * 
		 * return true; } catch (Throwable t) { // TODO: handle exception return false;
		 * }
		 */
		
		int size= driver.findElements(by).size();
		if(size==0) {
			return false;
		}else {
			return true;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		int size = driver.findElements(By.xpath("//div[4]/input")).size();
		
		/*
		 * for(int i=1;i<=size;i++) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click(); }
		 */
		
		/*
		 * int i =1; int count=0;
		 * while(isElementPresent(By.xpath("//div[4]/input["+i+"]"))==true) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click(); i++; count++;
		 * 
		 * }
		 * 
		 * System.out.println("Total count ="+count);
		 * 
		 * driver.close();
		 */
		WebElement section = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes =section.findElements(By.name("sports"));
		
		System.out.println("Total check box "+checkboxes.size());
		
		for(WebElement check:checkboxes) {
			check.click();
		}
		driver.quit();
	}

   
}
