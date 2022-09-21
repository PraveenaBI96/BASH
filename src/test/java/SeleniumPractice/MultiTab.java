package SeleniumPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiTab {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("http://flipkart.com/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.linkedin.com/login");
	Set<String> allId = driver.getWindowHandles();
	for (String id : allId) {
		System.out.println(id);
	}
	
	Actions act = new Actions(driver);
	
	}
}
