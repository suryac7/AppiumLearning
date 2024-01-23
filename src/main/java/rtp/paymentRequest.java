package rtp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class paymentRequest {

	public static AndroidDriver driver;
	@Test
	public static void rtp() throws InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("platformversion","12" );
		capabilities.setCapability("udid", "d8cd3df1");
		capabilities.setCapability("devicename", "realme 7 Pro");
		capabilities.setCapability("appPackage", "com.atpayments");
		capabilities.setCapability("appActivity", "com.atpayments.MainActivity");
		capabilities.setCapability("automationName", "UIAutomator2");

		URL url= null;
		try {
			url = new URL("http://0.0.0.0:4723/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new AndroidDriver(url,capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Login
		WebElement Username = driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id=\"text-input-outline\"])[1]"));
		Username.click();
		WebElement Username1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\" and @text=\"User Name\"]"));
		Username1.sendKeys("Katherine@phonepe");
		WebElement Password = driver.findElement(By.xpath("(//android.widget.EditText[@resource-id=\"text-input-outlined\"])[2]"));
		Password.click();
		WebElement Password1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\" and @text=\"Password\"]"));
		Password1.sendKeys("Katherine*123");
		WebElement login = driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[2]"));
		login.click();
		WebElement message = driver.findElement(By.xpath("//*[@text='Success']"));
		String actualmessage = message.getText();
		System.out.println(actualmessage);
		String Expectedmessage = "Success";
		Assert.assertEquals(actualmessage, Expectedmessage);
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		ok.click();
		
		//Payments
		WebElement payments = driver.findElement(By.xpath("//*[@text='Payments']"));
		payments.click();
		WebElement Tina = driver.findElement(By.xpath("//*[@text='Tina']"));
		Tina.click();
		
		//Amount Modification
		WebElement amount = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.ImageView"));
		amount.click();
		WebElement amount1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\"]"));
		amount1.click();
		WebElement enter = driver.findElement(By.xpath("//*[@text='Enter the Amount..']"));
		enter.sendKeys("15");
		driver.navigate().back();
		WebElement payNow = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) payNow).getId()));	
		WebElement close = driver.findElement(By.xpath("//*[@text='Close']"));
		close.click();
		


	}
}
