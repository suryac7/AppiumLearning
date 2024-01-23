package appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Swipe {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("platformversion","12" );
		capabilities.setCapability("udid", "d8cd3df1");
		capabilities.setCapability("devicename", "realme 7 Pro");
		capabilities.setCapability("appPackage", "com.touchboarder.android.api.demos");
		capabilities.setCapability("appActivity", "com.touchboarder.androidapidemos.MainActivity");
		capabilities.setCapability("automationName", "UIAutomator2");

		URL url = new URL("http://0.0.0.0:4723/");
		driver = new AndroidDriver(url,capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Open API Demo application
				WebElement storage = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[1]"));
				storage.click();
				WebElement allow = driver.findElement(By.id("android:id/button1"));
				allow.click();
				WebElement Contacts = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[2]"));
				Contacts.click();
				WebElement Location = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[3]"));
				Location.click();
				WebElement Phone = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[4]"));
				Phone.click();
				WebElement micro = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[5]"));
				micro.click();
				WebElement camera = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[6]"));
				camera.click();
				WebElement continu = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
				continu.click();
				WebElement ok = driver.findElement(By.id("android:id/button1"));
				ok.click();
				WebElement accept = driver.findElement(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive"));
				accept.click();

				//Open API Demos
				WebElement apidemo = driver.findElement(By.xpath("//*[@text='API Demos']"));
				apidemo.click();

				//Click views & Drag and Drop
				WebElement views = driver.findElement(By.xpath("//*[@text='Views']"));
				views.click();
				
				//Scroll
				AppiumBy Seekbar = (AppiumBy) AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"));");
		        driver.findElement(Seekbar).click();
				
				//Swipe
				WebElement bar = driver.findElement(By.id("com.touchboarder.android.api.demos:id/seek"));
				((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(  
		                "elementId",((RemoteWebElement) bar).getId(),
		                "direction", "right",
		                "percent", 0.75));


	}

}
