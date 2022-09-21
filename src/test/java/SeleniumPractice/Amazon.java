package SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	public void getPriceAndProductName() throws InterruptedException
	{ 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/descendant::span[@class='s-heavy' and text()=' 12']")).click();
		List<WebElement> prodName = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		/*
		 * for (WebElement wb : prodName) { System.out.println(wb.getText()); }
		 */
		
	}
}
