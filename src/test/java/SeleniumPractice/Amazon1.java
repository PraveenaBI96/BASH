package SeleniumPractice;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		WebElement iphone12 = driver.findElement(By.xpath("//span[.=' mini']"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(" //span[.=' mini']"))));
		iphone12.click();
		List<WebElement> allMobile = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	    List<WebElement> allPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
//		for (WebElement mobile : allMobile) {
//		   WebElement price = driver.findElement(By.xpath("//span[.='"+mobile.getText()+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
//		   System.out.println(mobile.getText()+" : "+price.getText());
//		}
		System.out.println("----------------------------");
		
		String[] s1=new String[allPrice.size()];
		int count=0;
		for (WebElement mobPrice : allPrice) {
			
			s1[count]=mobPrice.getText();
			count++;
		}
		
		LinkedList<String> product=new LinkedList<String>();
		int i = 0;
		for (WebElement mobile : allMobile) {
			for (; i < s1.length;) {
				product.add(mobile.getText()+" : "+s1[i]);
				System.out.println(mobile.getText()+" : "+s1[i]);
				i++;
				break;
			}
		}
		System.out.println("----------------------------");
		
//		TreeSet<Integer>  set= new TreeSet<Integer>();
//		for (WebElement mobPrice : allPrice) {
//			String pr = mobPrice.getText().replace(",", "");
//			int pr1=Integer.parseInt(pr);
//		    set.add(pr1);
//		}
		LinkedList<String> list=new LinkedList<String>();
		for (WebElement mobPrice : allPrice) {
			String pr = mobPrice.getText();
		    list.add(pr);
		}
		Collections.sort(list);
		TreeSet<String> set = new TreeSet<String>();
		for (String prise1 : list) {
			set.add(prise1);
		}
	
		for (String obj : set) {
			for (String prod : product) {
				if(prod.contains(obj))
				{
					System.out.println(prod);
				}
			}	
		}
		
	}
}
