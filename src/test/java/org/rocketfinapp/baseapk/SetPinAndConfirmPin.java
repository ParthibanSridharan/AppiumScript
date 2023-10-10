package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetPinAndConfirmPin extends Basetestrocketfin{
	
	
	@Test(priority = 0)
	public void SetPinpageTitle() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Set Pin']")).getText();
		extentTest.info(actualTitle);

		Assert.assertEquals(actualTitle, "Set Pin");

	}
	@Test(priority = 1)
	public void setpinpage() throws InterruptedException {
		// Set pin page
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Set']")).click();

	}
	@Test(priority = 2)
	public void ConfirmPinpageTitle() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Confirm Pin']")).getText();
		extentTest.info(actualTitle);

		Assert.assertEquals(actualTitle, "Confirm Pin");
	}
	@Test(priority = 3)
	public void AlertforPinMismatch() throws InterruptedException {

		// confirm pin page
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Confirm']")).click();
		String actualalert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.TextView[1]")).getText();
		extentTest.info(actualalert);

		Assert.assertEquals(actualalert, "PIN doesn't match. Please try again.");
	
	}
	@Test(priority = 3)
	public void Validpinconfirm() throws InterruptedException {

		// confirm pin page
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Confirm']")).click();
		extentTest.info("Pin set successfull");
	}
	
	
	
}
