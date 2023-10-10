package org.rocketfinapp.baseapk;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AadharVerificationPage extends Basetestrocketfin {

	
	@Test(priority = 0)
	public void AadharVerificationpageTitle() throws InterruptedException {
		Thread.sleep(1000);
		String Expected_Result="Aadhaar Verification";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualTitle = driver.findElement(By.xpath("//android.widget.TextView[@text='Aadhaar Verification']")).getText();
		extentTest.info("Actual_Title:"+actualTitle);

		Assert.assertEquals(actualTitle, "Aadhaar Verification");

	}
	@Test(priority = 1)
	public void Placeholder() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Aadhaar Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String Placeholder = driver.findElement(By.xpath("//android.widget.TextView[@text='Aadhaar Number']")).getText();
		extentTest.info("Actual_Title:"+Placeholder);

		Assert.assertEquals(Placeholder, "Aadhaar Number");
	}
	@Test(priority = 2)
	public void Alertwithoutinput() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Aadhaar Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Aadhaar Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Aadhaar Number");
	}
	@Test(priority = 3)
	public void AlertForinvalidnumber_startsWith0() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String number = RandomStringUtils.randomNumeric(11);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("0" + number);
		driver.hideKeyboard();
		Thread.sleep(1000);
		String Expected_Result="Please Enter Valid Aadhaar Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String actualalert = driver
				.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Aadhaar Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Aadhaar Number");
	}
	@Test(priority = 4)
	public void AlertForinvalidnumber_startsWith1() throws InterruptedException {

		Thread.sleep(2000);
		String number = RandomStringUtils.randomNumeric(11);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("1" + number);
		Thread.sleep(2000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Aadhaar Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Aadhaar Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Aadhaar Number");
	}
	@Test(priority = 5)
	public void AlertForinvalidinputDigits() throws InterruptedException {

		Thread.sleep(2000);
		String number = RandomStringUtils.randomNumeric(9);
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("5" + number);
		Thread.sleep(1000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="Please Enter Valid Aadhaar Number";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='Please Enter Valid Aadhaar Number']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "Please Enter Valid Aadhaar Number");
	}
	@Test(priority = 5)
	public void AlertforAadharnumber_alreadyexists() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("410314114027");
		Thread.sleep(1000);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		String Expected_Result="User is already registered";
		extentTest.info("Expected_Result:"+Expected_Result);
		String actualalert = driver.findElement(By.xpath("//android.widget.TextView[@text='User is already registered']")).getText();
		extentTest.info("Actual_Result:"+actualalert);

		Assert.assertEquals(actualalert, "User is already registered");
	}
	@Test(priority = 6)
	public void Submitbutton_Withoutinput() throws InterruptedException {

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.hideKeyboard();
		String Expected_Result="Next Submit is disabled";
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

		Thread.sleep(3000);

		driver.findElement(By.className("android.widget.EditText")).click();
		String number = RandomStringUtils.randomNumeric(9);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("982" + number);
		driver.hideKeyboard();
		String Expected_Result="Next Submit is enabled";
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
	public void Skip_linktext() throws InterruptedException {
		// Add code to trigger an alert if necessary
		Thread.sleep(2000);
		String Expected_Result="Skip?";
		extentTest.info("Expected_Result:"+Expected_Result);
		String linktext = driver.findElement(By.xpath("//android.widget.TextView[@text='Skip?']")).getText();
		extentTest.info("Actual_Result:"+linktext);

		Assert.assertEquals(linktext, "Skip?");
	}
	@Test(priority = 9)
	public void ValidAadharnumber() throws InterruptedException {
	// Add code to trigger an alert if necessary
	Thread.sleep(3000);
	String number = RandomStringUtils.randomNumeric(11);
	driver.findElement(By.className("android.widget.EditText")).clear();
	driver.findElement(By.className("android.widget.EditText")).sendKeys("4" + number);
	driver.hideKeyboard();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button")).click();
	extentTest.info("Actual Result:Aadhar OTP is sent to the registered mobile");

	}

}
