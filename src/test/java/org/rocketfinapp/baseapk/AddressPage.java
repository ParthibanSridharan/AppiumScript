package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddressPage extends Basetestrocketfin {
	
	@Test(priority = 0)
	public void AddressPage_Title() throws InterruptedException {
		Thread.sleep(2000);
		// Get the actual title from the app
		String Expected_Result="Address";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Address']")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "Address");
	}
	@Test(priority = 1)
	public void VerifyAddressCheckbox_isselected() throws InterruptedException {
		// select accounts page
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		String Expected_Result="Account is selected";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean checkbox =driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image")).isEnabled();
		if(checkbox==true)
		{
			extentTest.info("Actual_Result:Account is selected");
		} else {
			extentTest.info("Actual_Result:Account is not selected");
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
	}
	@Test(priority = 2)
	public void Choosebutton_WithoutinputOTP() throws InterruptedException {
		Thread.sleep(2000);
		String Expected_Result="Choose button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Choose']")).isEnabled();
		if (button == false) {
			extentTest.info("Choose button is disabled");
		} else {
			extentTest.info("Choose button is enabled");
			Assert.assertFalse(true);

		}
	}
	@Test(priority = 3)
	public void Choosebutton_WithinputOTP() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		String Expected_Result="Choose button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Choose']")).isEnabled();
		if (button == true) {
			extentTest.info("Choose button is enabled");
		} else {
			extentTest.info("Choose button is disabled");
			Assert.assertTrue(false);

		}
	}
	@Test(priority = 4)
	public void Addresspage() throws InterruptedException {
//Address page
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View"))
				.click();
		// driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Choose']")).click();
		extentTest.info("Actual_Result:Address is selected");
		Thread.sleep(3000);
	}
}
