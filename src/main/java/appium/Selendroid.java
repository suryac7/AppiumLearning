package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class Selendroid {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("platformversion","12" );
		capabilities.setCapability("udid", "d8cd3df1");
		capabilities.setCapability("devicename", "realme 7 Pro");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		capabilities.setCapability("automationName", "UIAutomator2");
		
		URL url = new URL("http://0.0.0.0:4723/");
		driver = new AndroidDriver(url,capabilities);
		
		//Open Selendroid APK	
		WebElement phone = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[1]"));
		phone.click();
		Thread.sleep(3000);
		WebElement phone1 = driver.findElement(By.id("android:id/button1"));
		phone1.click();
		WebElement calllogs = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[2]"));
		calllogs.click();
		WebElement storage = driver.findElement(By.xpath("(//android.widget.Switch[@resource-id=\"android:id/switch_widget\"])[3]"));
		storage.click();
		WebElement continu = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		continu.click();
		Thread.sleep(3000);
		WebElement ok = driver.findElement(By.id("android:id/button1"));
		ok.click();
		
		//Register a data
		WebElement register = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"startUserRegistrationCD\"]"));
		register.click();
		Thread.sleep(3000);
		WebElement Username = driver.findElement(By.id("io.selendroid.testapp:id/inputUsername"));
		Username.sendKeys("Surya");
		WebElement email = driver.findElement(By.id("io.selendroid.testapp:id/inputEmail"));
		email.sendKeys("suryavenkat121@gmail.com");
		WebElement password = driver.findElement(By.id("io.selendroid.testapp:id/inputPassword"));
		password.sendKeys("Sollamudiyathu");
		WebElement name = driver.findElement(By.id("io.selendroid.testapp:id/inputName"));
		name.clear();
		name.sendKeys("Jack Sparrow");
		WebElement language = driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage"));
		language.click();
		Thread.sleep(3000);
		WebElement java = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Java\"]"));
		java.click();
		driver.navigate().back();
		WebElement accept = driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
		accept.click();
		WebElement verify = driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser"));
		verify.click();
		
	}

}
