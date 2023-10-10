package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChooseEmailPage extends Basetestrocketfin {

	@Test(priority = 0)
	public void ChooseEmailPage_Title() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String Expected_Result="Choose Email";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Choose Email']")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "Choose Email");

	}
	@Test(priority = 1)
	public void VerifyEmailCheckbox_isselected() throws InterruptedException {
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
			extentTest.info("Actual Result:Account is selected");
		} else {
			extentTest.info("Actual Result:Account is not selected");
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
	}
	@Test(priority = 2)
	public void Addbutton_WithoutinputOTP() throws InterruptedException {
		Thread.sleep(2000);
		String Expected_Result="Add Button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Add']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Add button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Add button is enabled");
				Assert.assertFalse(true);
			}
	}
	@Test(priority = 3)
	public void Addbutton_WithinputOTP() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		String Expected_Result="Add Button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Add']")).isEnabled();
		if (button == true) {
			extentTest.info("Actual_Result:Add button is enabled");
		} else {
			extentTest.info("Actual_Result:Add button is disabled");
			Assert.assertTrue(false);

		}
	}
	@Test(priority = 4)
	public void MyEmailIsNotListed_Linktext() throws InterruptedException {
		//unselecting the checkbox
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
		.click();
		Thread.sleep(2000);
		String Expected_Result="My email is not listed?";
		extentTest.info("Expected_Result:"+Expected_Result);
		String linktext = driver.findElement(By.xpath("//android.widget.TextView[@text='My email is not listed?']")).getText();
		extentTest.info("Actual_Result:"+linktext);
		Assert.assertEquals(linktext, "My email is not listed?");
	}
	@Test(priority = 5)
	public void EmailisSelected() throws InterruptedException {

		// Add Email page
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		// driver.findElement(By.xpath("//android.widget.Image[@text='square
		// outline']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Add']")).click();
		extentTest.info("Actual_Result:Email is Selected");
	}
}
