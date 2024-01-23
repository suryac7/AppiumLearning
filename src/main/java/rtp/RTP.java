package rtp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class RTP {

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

		//Scroll the element
		AppiumBy Scroll = (AppiumBy) AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\" + Request Money\"));");
		driver.findElement(Scroll).click();

		//Search User
		WebElement searchbar = driver.findElement(By.xpath("//*[@text='Enter contact ID / payment address']"));
		searchbar.click();
		searchbar.sendKeys("smit");
		driver.navigate().back();
		WebElement smith = driver.findElement(By.xpath("//*[@text='smith']"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) smith).getId()
				));

		//New Request
		WebElement amount = driver.findElement(By.xpath("//*[@text='Amount']"));
		amount.click();
		WebElement amount1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id=\"text-input-outlined\" and @text=\"0.00\"]"));
		amount1.sendKeys("75");
		WebElement howLongToPay = driver.findElement(By.xpath("//*[@text='How long to pay']"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) howLongToPay).getId()));
		WebElement date = driver.findElement(By.xpath("//*[@text='26']"));
		date.click();
		WebElement notes = driver.findElement(By.xpath("//*[@text='Notes']"));
		notes.click();
		WebElement notes1 = driver.findElement(By.xpath("//*[@text='Type Something...']"));
		notes1.sendKeys("Test");
		driver.navigate().back();
		
		WebElement amountModify = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch[1]"));
		amountModify.click();
		WebElement payLater = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch[2]"));
		payLater.click();
		WebElement paymentTerm = driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.ImageView"));
		paymentTerm.click();
		WebElement mode = driver.findElement(By.xpath("//*[@text='Payment wire transfer']"));
		mode.click();
		AppiumBy requestPayment = (AppiumBy) AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Request Payment\"));");
		driver.findElement(requestPayment).click();
		//WebElement requestPayment = driver.findElement(By.xpath("//*[@text='Request Payment']"));
		//requestPayment.click();
		//Thread.sleep(6000);
		int timeoutInSeconds = 10;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		WebElement done = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//android.widget.TextView[@text=\"Done\"]"))));
		done.click();
		
		

	}




}
