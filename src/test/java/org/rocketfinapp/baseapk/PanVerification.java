package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PanVerification extends Basetestrocketfin{
	
	@Test(priority = 0)
	public void PAN_VerificationpageTitle() throws InterruptedException {
		Thread.sleep(1000);
		String Expected_Result="PAN Verification";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='PAN Verification']")).getText();
		extentTest.info("Actual_Result:"+actualTitle);

		Assert.assertEquals(actualTitle, "PAN Verification");
	
	}
	@Test(priority = 1)
	public void Placeholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="PAN Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String Placeholder = driver.findElement(By.xpath("//android.widget.TextView[@text='PAN Number']")).getText();
		extentTest.info("Actual_Result:"+Placeholder);

		Assert.assertEquals(Placeholder, "PAN Number");
	}
	@Test(priority = 1)
	public void Alertwithoutinput() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Please Enter Valid Pan Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();

		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Pan Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Pan Number");
	}

	@Test(priority = 2)
	public void AlertForinvalidPANnumber() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String number = RandomStringUtils.randomNumeric(7);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123" + number);
		Thread.sleep(1000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Pan Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Pan Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);
		Assert.assertEquals(actualalert, "Please Enter Valid Pan Number");
	}

	@Test(priority = 3)
	public void AlertForinvalidinputdigits() throws InterruptedException {

		Thread.sleep(3000);
		String panChar = RandomStringUtils.randomAlphabetic(5);
		String panNumber = RandomStringUtils.randomNumeric(3);
		String panLastLetter = RandomStringUtils.randomAlphabetic(1);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(panChar + panNumber + panLastLetter);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Pan Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Pan Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Pan Number");
	}
	@Test(priority = 4)
	public void AlertForinvalidinputChars() throws InterruptedException {

		Thread.sleep(3000);
		String panChar = RandomStringUtils.randomAlphabetic(5);
		String panNumber = RandomStringUtils.randomNumeric(3);
		String panLastLetter = RandomStringUtils.randomAlphabetic(1);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(panNumber + panChar + panLastLetter);
		Thread.sleep(2000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Pan Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Pan Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Pan Number");
	}
	@Test(priority = 5)
	public void Alertforexistingmobilenumber() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("ETEPP1365L");
		Thread.sleep(1000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="User is already registered";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver
				.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.TextView")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "User is already registered");
	}
	@Test(priority = 6)
	public void Submitbutton_Withoutinput() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.hideKeyboard();
		String Expected_Result="Submit button is disabled";
		extentTest.info("Expected_Result:"+Expected_Result);
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Submit button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Submit button is enabled");
				Assert.assertFalse(true);
			}
		}
	@Test(priority = 7)
	public void Submitbutton_Withinput() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).click();
		String panChar = RandomStringUtils.randomAlphabetic(5);
		String panNumber = RandomStringUtils.randomNumeric(4);
		String panLastLetter = RandomStringUtils.randomAlphabetic(1);
		driver.findElement(By.className("android.widget.EditText")).sendKeys(panChar + panNumber + panLastLetter);
		Thread.sleep(1000);
		driver.hideKeyboard();
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
	@Test(priority = 8)
	public void Tryanotherproof_linktext() throws InterruptedException {
		Thread.sleep(1000);

		String Expected_Result="Try Other Address Proof?";
		extentTest.info("Expected_Result:"+Expected_Result);
		String linktext = driver.findElement(By.xpath("//android.widget.TextView[@text='Try Other Address Proof?']")).getText();
		extentTest.info("Actual_Result:"+linktext);

		Assert.assertEquals(linktext, "Try Other Address Proof?");
	}
	@Test(priority = 9)
	public void ValidPANnumber() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(2000);
	String panChar = RandomStringUtils.randomAlphabetic(5);
	String panNumber = RandomStringUtils.randomNumeric(4);
	String panLastLetter = RandomStringUtils.randomAlphabetic(1);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys(panChar + panNumber + panLastLetter);
	Thread.sleep(1000);
	driver.hideKeyboard();
	driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	extentTest.info("Actual Result:PAN verification successfull");

	}

}
