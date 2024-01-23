package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Appiumcalculator {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("udid", "d8cd3df1");
		capabilities.setCapability("deviceName", "realme 7 Pro");
		capabilities.setCapability("appPackage", "com.coloros.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		capabilities.setCapability("automationName", "UIAutomator2");

		URL url = new URL("http://0.0.0.0:4723/");

		driver = new AndroidDriver(url,capabilities);

		System.out.println("Done");


		WebElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
		WebElement plus = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		WebElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_3"));
		WebElement add = driver.findElement(By.id("com.coloros.calculator:id/eq"));

		one.click();
		plus.click();
		two.click();
		add.click();




	}

}
