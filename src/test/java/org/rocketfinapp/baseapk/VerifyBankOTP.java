package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyBankOTP extends Basetestrocketfin{
	@Test(priority = 0)
	public void MobilenumberotppageTitle() throws InterruptedException {
		Thread.sleep(3000);

		String Expected_Result="Verify";
		extentTest.info("Expected_Result:"+Expected_Result);
		// Get the actual title from the app
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Verify']")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "Verify");
	}
	@Test(priority = 1)
	public void OTPPlaceholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(1000);
		driver.findElement(By.className("android.widget.EditText")).clear();
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
		Thread.sleep(1000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.hideKeyboard();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
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
		String number = RandomStringUtils.randomNumeric(2);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("01" + number);
		Thread.sleep(2000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid OTP']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}
	@Test(priority = 4)
	public void AlertForinvalidinputdigits_OTP() throws InterruptedException {

		Thread.sleep(1000);
		String number = RandomStringUtils.randomNumeric(5);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("1" + number);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid OTP";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid OTP']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid OTP");
	}
	@Test(priority = 5)
	public void Verifybutton_WithoutinputOTP() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.hideKeyboard();
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
	@Test(priority = 6)
	public void Verifybutton_WithinputOTP() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		String number = RandomStringUtils.randomNumeric(5);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("1" + number);
		driver.hideKeyboard();
		Thread.sleep(2000);
		String Expected_Result="Verify Button is enabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).isEnabled();
		if (button == true) {
			extentTest.info("Actual_Result:Verify button is enabled");
		} else {
			extentTest.info("Actual_Result:Verify button is disabled");
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 7)
	public void ResendOTPLink_text() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Resend OTP?";
		extentTest.info("Expected_Result:"+Expected_Result);
		String linktext = driver.findElement(By.xpath("//android.widget.TextView[@text='Resend OTP?']")).getText();
		extentTest.info("Actual_Result:"+linktext);
		Assert.assertEquals(linktext, "Resend OTP?");
	}
	@Test(priority = 8)
	public void Valid_OTP() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(2000);
	String number = RandomStringUtils.randomNumeric(5);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys("1" + number);
	Thread.sleep(2000);
	driver.hideKeyboard();
	driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	extentTest.info("Actual Result:OTP is Verified successfully");

	}	
}
