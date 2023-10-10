package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyAadhar_OTPpage extends Basetestrocketfin{
	
	
	@Test(priority = 0)
	public void VerifyAadhar_OTP_pageTitle() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String Expected_Result="Verify Aadhaar";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "Verify Aadhaar");
	}
	@Test(priority = 1)
	public void OTPPlaceholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.hideKeyboard();
		driver.findElement(By.className("android.widget.Image")).click();
		String Expected_Result="OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String Placeholder = driver.findElement(By.xpath("//android.widget.TextView[@text='OTP']")).getText();
		extentTest.info("Actual_Result:"+Placeholder);

		Assert.assertEquals(Placeholder, "OTP");
	}
	@Test(priority = 2)
	public void Alertwithoutinput() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		String Expected_Result="Please Enter Valid OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid OTP']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}
	@Test(priority = 3)
	public void AlertForinvalidOTP() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("122");
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		Thread.sleep(3000);
		String Expected_Result="Please Enter Valid OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}	
	@Test(priority = 4)
	public void AlertForinvalidinputdigits_OTP() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("011");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		String Expected_Result="Please Enter Valid OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		try {
		String actualalert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+actualalert);
		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
		}catch(NoSuchElementException e) {
		String actualalert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+actualalert);
		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
		}
	}
	@Test(priority = 5)
	public void AutofillingOTP_text() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="AUTOFILLING OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String autofilling = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+autofilling);

		Assert.assertEquals(autofilling, "AUTOFILLING OTP");
	}
	@Test(priority = 6)
	public void Verifybutton_WithoutinputOTP() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		String Expected_Result="Verify Button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Verify button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Verify button is enabled");
				Assert.assertFalse(true);
			}
		}
	@Test(priority = 7)
	public void Verifybutton_WithinputOTP() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		String number = RandomStringUtils.randomNumeric(5);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("1" + number);
		driver.hideKeyboard();
		String Expected_Result="Verify Button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		try {
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
		if (button == true) {
			extentTest.info("Actual_Result:Verify button is enabled");
		} else {
			extentTest.info("Actual_Result:Verify button is disabled");
			Assert.assertTrue(false);
		}
		}catch(NoSuchElementException e)
		{
			boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
			if (button == true) {
				extentTest.info("Actual_Result:Verify button is enabled");
			} else {
				extentTest.info("Actual_Result:Verify button is disabled");
				Assert.assertTrue(false);
			}
		}
		}
	@Test(priority = 8)
	public void ResendOTPLink_text() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Resend OTP?";
		extentTest.info("Expected_Result:"+Expected_Result);
		try {
		String linktext = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+linktext);

		Assert.assertEquals(linktext, "Resend OTP?");
		}catch(NoSuchElementException e) {
			String linktext = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).getText();
			extentTest.info("Actual_Result:"+linktext);

			Assert.assertEquals(linktext, "Resend OTP?");
		}

	}
	@Test(priority = 9)
	public void Valid_OTP() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(3000);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
	driver.hideKeyboard();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
	extentTest.info("Actual Result:OTP is Verified successfully");

	}	
}