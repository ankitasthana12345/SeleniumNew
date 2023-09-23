package com.testingpractice.selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelectClassHand {
	
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	//	driver.get("https://www.way2automation.com/way2auto_jquery/index.php");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		driver.get("https://www.wikipedia.org/");
		
		/*
		 * List<WebElement> ele=driver.findElements(By.xpath("//input"));
		 * 
		 * System.out.println(ele.size()); driver.quit();
		 */
		System.out.println(isElementPresent(By.xpath("//select[@id='searchLanguage1']")));
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage1']"));
		
//		wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		List<WebElement> values = driver.findElements(By.tagName("option"));
		
		System.out.println("Total value"+ values.size());
		
		System.out.println("Value 12 ="+ values.get(12).getAttribute("value"));
		
		/*
		 * for(WebElement val: values) { System.out.println(val.getText()); }
		 */
		
		/*
		 * for(int i=0;i<values.size();i++) { values.get(i).getAttribute("value"); }
		 */
		//List<WebElement> op=select.getOptions();
		for(int i=0;i<select.getOptions().size();i++) {
			System.out.println(select.getOptions().get(i).getText());
		}
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		List<WebElement> links = block.findElements(By.tagName("a"));
		 System.out.println("Links in block=========");
		 System.out.println("Size = "+links.size());
		for(WebElement link : links) {
			System.out.println(link.getText());
		}
		
		
		
		driver.quit();

	}

}
