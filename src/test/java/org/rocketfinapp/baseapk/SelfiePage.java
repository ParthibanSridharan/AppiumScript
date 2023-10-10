package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SelfiePage extends Basetestrocketfin {
	
	@Test(priority = 0)
	public void allow() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();	
	}
	@Test(priority = 1)
	public void Cameraoptions() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.camera:id/right_button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]")).click();
		Thread.sleep(4000);
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
	}
	@Test(priority = 2)
	public void SelfiePage_Title() throws InterruptedException {
		Thread.sleep(2000);
		// Get the actual title from the app
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Capture']")).getText();
		extentTest.info(actualTitle);

		Assert.assertEquals(actualTitle, "Capture");
	}
	
}
