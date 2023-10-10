package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Mobilenumberpage extends Basetestrocketfin {

	@Test(priority = 0)
	public void MobilenumberpageTitle() throws InterruptedException {
		Thread.sleep(3000);
		try {
			driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		} catch (Exception e) {
			driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		}
		// Get the actual title from the app
		String Expected_Result="Register";
		String Actual_Title = driver.findElement(By.xpath("//android.widget.TextView[@text='Register']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Actual_Title);

		Assert.assertEquals(Actual_Title, "Register");

	}
	@Test(priority= 1)
	public void Progressinfo() throws InterruptedException {
		// Get the actual title from the app
		String Expected_Result="(1/10)";
		String Actual_Title = driver.findElement(By.xpath("//android.widget.TextView[@text='(1/10)']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Actual_Title);

		Assert.assertEquals(Actual_Title, "(1/10)");

	}
	@Test(priority = 2)
	public void Placeholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Mobile Number";
		String Placeholder = driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile Number']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Placeholder);

		Assert.assertEquals(Placeholder, "Mobile Number");
	}

	@Test(priority = 3)
	public void Alertwithoutinput() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		String Expected_Result="Please Enter Valid Mobile Number";
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Mobile Number']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Mobile Number");
	}

	@Test(priority = 4)
	public void AlertForinvalidmobilenumber() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		String number = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123" + number);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		String Expected_Result="Please Enter Valid Mobile Number";
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Mobile Number']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Mobile Number");
	}

	@Test(priority = 5)
	public void AlertForinvalidinputdigits() throws InterruptedException {

		Thread.sleep(3000);
		String number = RandomStringUtils.randomNumeric(5);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("982" + number);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		String Expected_Result="Please Enter Valid Mobile Number";
		String actualalert = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Mobile Number']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Mobile Number");
	}
	@Test(priority = 6)
	public void AlertForinvalidinput1stdigit() throws InterruptedException {

		Thread.sleep(3000);
		String number = RandomStringUtils.randomNumeric(9);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("5" + number);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		String Expected_Result="Please Enter Valid Mobile Number";
		String actualalert = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Mobile Number']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Mobile Number");
	}
	@Test(priority = 7)
	public void Alertforexistingmobilenumber() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(1000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("9962618921");
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		String Expected_Result="Please Enter Valid Mobile Number";
		Thread.sleep(1000);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='User is already registered']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Mobile Number");

}
	@Test(priority = 8)
	public void RequestOTPbutton_Withoutinput() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.hideKeyboard();
		String Expected_Result="Request_OTP Button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Request_OTP button is disabled");
		} else {
			extentTest.info("Actual_Result:Request_OTP button is enabled");
			Assert.assertFalse(true);

		}
	}
	@Test(priority = 9)
	public void RequestOTPbutton_Withinput() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		String number = RandomStringUtils.randomNumeric(6);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("9" + number+"226");
		driver.hideKeyboard();
		String Expected_Result="Request_OTP button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).isEnabled();
		if (button == true) {
			extentTest.info("Actual_Result:Request_OTP button is enabled");
		} else {
			extentTest.info("Actual_Result:Request_OTP button is disabled");
			Assert.assertTrue(false);

		}
	}
	@Test(priority = 10)
	public void Validmobilenumber() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(3000);
	String number = RandomStringUtils.randomNumeric(9);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys("9" + number);
	Thread.sleep(2000);
	driver.findElement(By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
			.click();
	driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
	extentTest.info("Actual_Result:OTP is sent to the registered mobile");

	}
	@Test(priority = 11)
	public void VerifyAnOTPhasBeenSentToYourMobileNumber_ToastMessage() throws InterruptedException {
	String Expected_Result="An OTP has been sent to your mobile numberXXXXXXX226";
	extentTest.info("Expected_Result:"+Expected_Result);
	String Actual_Result= driver.findElement(By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView"))
			.getText();
	
	extentTest.info("Actual_Result:"+Actual_Result);

	}
}



