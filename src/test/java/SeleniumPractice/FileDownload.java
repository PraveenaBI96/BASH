package SeleniumPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;

public class FileDownload {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions options=new ChromeOptions();
	Map<String,Object> prefs = new HashMap<String, Object>();
	prefs.put("download.prompt_for_download", "./Downloads");
	options.setExperimentalOption("prefs", prefs);
	WebDriver driver = new ChromeDriver(options);
	((ChromeDriver) driver).setFileDetector(new LocalFileDetector());
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://files-go.en.uptodown.com/android/download");
	driver.findElement(By.xpath("//strong[.='Download']")).click();
	driver.quit();
}
}