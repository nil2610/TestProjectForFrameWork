package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.helpers.MouseActionHelper;
import com.utilities.UploadFileUtil;

public class launchurl {
	
	WebDriver driver;
	BaseClass baseClass;
	
	@Test
	public void testing() throws Exception {
		baseClass = new BaseClass();
		driver = baseClass.browserLaunch("chrome");
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\VCN\\Desktop\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();*/
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		System.out.println("testing start");
		
		driver.get("http://demo.guru99.com/test/upload/");
		
		WebElement element = driver.findElement(By.id("uploadfile_0"));

		MouseActionHelper mouseMove = new MouseActionHelper(driver);
		mouseMove.mouseHoverClick(element);
		
		UploadFileUtil uploadFile = new UploadFileUtil();
		uploadFile.uploadFile("C:\\Users\\VCN\\Desktop\\test.jpg");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		
		Thread.sleep(3000);
		System.out.println("testing stop");
		
		driver.quit();
		
	}

}
