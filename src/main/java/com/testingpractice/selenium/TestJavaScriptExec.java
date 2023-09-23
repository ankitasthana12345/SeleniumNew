package com.testingpractice.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavaScriptExec {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.switchTo().frame("iframeResult");
	//	((JavascriptExecutor)driver).executeScript("myFunction()");
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
        WebElement button = driver.findElement(By.xpath("/html/body/button"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", button);
        driver.switchTo().defaultContent();
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"textareawrapper\"]/div/div[2]")));
        
		//driver.quit();

	}

}
