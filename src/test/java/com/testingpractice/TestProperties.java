package com.testingpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class.getName());
	
	public static void main(String[] args) throws IOException {
		Properties OR = new Properties();
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
	    log.info("OR file get loaded");
        System.out.println(OR.getProperty("username_ID"));
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
	    config.load(fis);
	    System.out.println(config.getProperty("browser"));
	    log.info("Config file get loaded");
	    
	    if(config.get("browser").equals("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    	log.info("Chrome browser launched!!");
	    	
	    }else if(config.get("browser").equals("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver = new FirefoxDriver();
	    	log.info("Fire fox browser launched!!");
	    }
	    
	    driver.get(config.getProperty("testurl"));
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    log.info("Test execution completed");
	}

}
