package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {
	@Test
public void searchElement() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div[position()=last()]")).click();
	WebElement thirdPage = driver.findElement(By.xpath("//a[@class='s-pagination-item s-pagination-button' and .='3']"));
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView()", thirdPage);
	thirdPage.click();

}
}

