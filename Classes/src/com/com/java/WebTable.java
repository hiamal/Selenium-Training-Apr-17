package com.com.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/hadmin/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://adactin.com/HotelApp/");
		
		driver.findElement(By.id("username")).sendKeys("hiamal007");
		driver.findElement(By.id("password")).sendKeys("test"+Keys.TAB);
		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.linkText("Booked Itinerary")).click();
		WebElement table = driver.findElement(By.xpath("(//table)[5]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		//System.out.println(rows.size());
		for(WebElement row:rows){
			List<WebElement> cols = row.findElements(By.tagName("input"));
			//System.out.println(cols.size());
			for(WebElement col:cols){
				System.out.print(col.getAttribute("value")+"\t");
			}
			System.out.println();
		}

	}

}