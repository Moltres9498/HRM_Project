package practice;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleVoice {

	static {
		System.setProperty("webdriver.chrome.driver","./config/chromedriver.exe");
	}
	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		
		HashMap<String, Integer> pref=new HashMap<String, Integer>();
		pref.put("profile.managed_default_content_settings.media_stream",1);
		
		option.setExperimentalOption("prefs", pref);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//*[local-name()='svg' and @class='goxjub']")).click();		
	}
}