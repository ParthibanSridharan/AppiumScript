package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Permissionspage extends Basetestrocketfin{

	// sms -check,popup
	@Test(priority = 0)
	public void smsallowpopup() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
	}
	@Test(priority = 1)
	public void Locationallowpopup() {
	// Location-check,popup
	driver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"))
			.click();
	driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
			.click();
	}
	@Test(priority = 2)
	public void contactsallowpopup() throws InterruptedException {
	// contacts-check,popup
	driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
	Thread.sleep(3000);
	}
	@Test(priority = 3)
	public void permissionspageTitle() throws InterruptedException {
		Thread.sleep(4000);
		// Get the actual title from the app
		String Expected_Result ="Permissions";
		String Actual_Title = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView")).getText();
		
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Actual_Title);

		Assert.assertEquals(Actual_Title, "Permissions");
	}
	
	@Test(priority = 4)
	public void NextButton() throws InterruptedException {
	Thread.sleep(1000);
	driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.widget.Button")).click();
	}
}

