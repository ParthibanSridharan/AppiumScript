package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SelectAccountsPage extends Basetestrocketfin{
	
	@Test(priority = 0)
	public void SelectAccountsPage_Title() throws InterruptedException {
		Thread.sleep(1000);
		String Expected_Result="Select Accounts";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Select Accounts']")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "Select Accounts");
	}
	@Test(priority = 1)
	public void VerifybankaccCheckbox_isselected() throws InterruptedException {
		// select accounts page
		Thread.sleep(3000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		String Expected_Result="Account is selected";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean checkbox =driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image")).isEnabled();
		if(checkbox==true)
		{
			extentTest.info("Actual_Result:Account is selected");
		} else {
			extentTest.info("Actual_Result:Account is not selected");
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
	}
	@Test(priority = 2)
	public void Submitbutton_WithoutinputOTP() throws InterruptedException {
		Thread.sleep(2000);
		String Expected_Result="Submit Button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Submit button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Submit button is enabled");
				Assert.assertFalse(true);
			}
		}
	@Test(priority = 3)
	public void Submitbutton_WithinputOTP() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		String Expected_Result="Submit Button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).isEnabled();
		if (button == true) {
			extentTest.info("Actual_Result:Submit button is enabled");
		} else {
			extentTest.info("Actual_Result:Submit button is disabled");
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 4)
	public void CannotfindyouraccountTryUPI_Link_text() throws InterruptedException {
		//unselecting the checkbox
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
		.click();
		Thread.sleep(2000);
		String Expected_Result="Cannot find your account ?\\r\\n\"+ \"Try UPI ➜";
		extentTest.info("Expected_Result:"+Expected_Result);
		String linktext = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Cannot find your account ?\r\n"+ "Try UPI ➜\"));")).getText();
		//String linktext = driver.findElement(By.xpath("//android.widget.TextView[@text='Cannot find your account ?\r\n"+ "Try UPI ➜']")).getText();
		extentTest.info("Actual_Result:"+linktext);

		Assert.assertEquals(linktext, "Cannot find your account ?\r\n"+ "Try UPI ➜");
	}
	
	@Test(priority = 5)
	public void Validaccountselected() throws InterruptedException {
		// select accounts page
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		extentTest.info("Actual_Result:Bank OTP is sent to registered mobile number");
	}
	
}	
	
	
	

