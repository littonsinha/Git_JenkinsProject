package com.qa.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage 
{
	public static WebDriver driver;
	

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "..\\Git_JenkinsProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void logintoApp()
	{
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("sinha.litton@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//div[text() ='Login']")).click();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}