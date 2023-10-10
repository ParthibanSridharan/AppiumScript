package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Mobilenumberotp extends Basetestrocketfin {
	
	
	@Test(priority = 0)
	public void MobilenumberotppageTitle() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String Expected_Result="Verify";
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Verify']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Title:"+actualTitle);

		Assert.assertEquals(actualTitle, "Verify");
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
	public void OTPPlaceholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="OTP";
		String Placeholder = driver.findElement(By.xpath("//android.widget.TextView[@text='OTP']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Placeholder);

		Assert.assertEquals(Placeholder, "OTP");
	}
	@Test(priority = 3)
	public void Alertwithoutinput() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		String Expected_Result="Please Enter Valid OTP";
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid OTP']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}
	@Test(priority = 4)
	public void AlertForinvalidOTP() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("122");
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		Thread.sleep(2000);
		String Expected_Result="Please Enter Valid OTP";
		String actualalert = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.TextView")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}	
	@Test(priority = 5)
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
	@Test(priority = 6)
	public void AutofillingOTP_text() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="AUTOFILLING OTP";
		String autofilling = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.TextView")).getText();
		extentTest.info(autofilling);
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+autofilling);
		Assert.assertEquals(autofilling, "AUTOFILLING OTP");
	}
	@Test(priority = 7)
	public void Verifybutton_WithoutinputOTP() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).clear();
		String Expected_Result="Next Button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Verify button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Verify button is enabled");
				Assert.assertFalse(true);
			}
		}

	@Test(priority = 8)
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
		}
		catch(NoSuchElementException e)
		{
			boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
			if (button == true) {
				extentTest.info("Actual_Result:Verify button is enabled");
			} else {
				extentTest.info("Actual_Result:Verify button is disabled");
				Assert.assertTrue(false);
			}
		
		}}
	@Test(priority = 9)
	public void ResendOTPLink_text() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Resend OTP?";
		extentTest.info("Expected_Result:"+Expected_Result);
		try {
		String linktext = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).getText();
		extentTest.info("Actual_Title:"+linktext);

		Assert.assertEquals(linktext, "Resend OTP?");
		}catch(NoSuchElementException e) {
			String linktext = driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).getText();
			extentTest.info("Actual_Title:"+linktext);

			Assert.assertEquals(linktext, "Resend OTP?");
		}

	}
	@Test(priority = 10)
	public void VerifyOTPHasBeenResent_ToastMessage() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).click();
		String Expected_Result="OTP has been resent to XXXXXXX226";
		String actualTitle = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Title:"+actualTitle);

		Assert.assertEquals(actualTitle, "OTP has been resent to XXXXXXX226");
	}
	@Test(priority = 11)
	public void VerifyPleasewaitFortheresendoptiontobecomeavailable_ToastMessage() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Resend OTP?\"]/android.widget.TextView")).click();
		String Expected_Result="Please wait for the resend option to become available.";
		String actualTitle = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Title:"+actualTitle);

		Assert.assertEquals(actualTitle, "Please wait for the resend option to become available.");
	}
	@Test(priority = 10)
	public void Valid_OTPWithToastMessage() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(3000);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
	driver.hideKeyboard();
	String Expected_Result="Mobile number OTP has been verified";
	extentTest.info("Expected Result:"+Expected_Result);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
	String ActualResult =driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView")).getText();
	Assert.assertEquals(ActualResult, "Mobile number OTP has been verified");
	extentTest.info("ActualResult:"+ActualResult);
	}

}