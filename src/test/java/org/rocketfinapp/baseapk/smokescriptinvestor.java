package org.rocketfinapp.baseapk;

import java.net.MalformedURLException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class smokescriptinvestor extends Basetestrocketfin {
	String number;
	String aadharNum;
	String panChar, panNumber, panLastLetter;
	String debitcardnumber, Name, cvv, Expdate;
	
	@Test
	public void signup() throws MalformedURLException {
		// Allow rocketfin to make and manage phone calls->allow
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();

	}

	@Test(dependsOnMethods = "signup")
	public void landingpageslides() throws InterruptedException {
		// landing page->signup
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Start']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Go to slide 4']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.view.View[@text='INVEST']")).click();
	}
	@Test(dependsOnMethods = "landingpageslides")
	public void permissionspage() throws InterruptedException {
		// Permissions page
		// sms -check,popup
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		// Location-check,popup
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"))
		.click();
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
		.click();
		// contacts-check,popup
		Thread.sleep(1000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(3000);
		// nextbutton
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
	}

	@Test(dependsOnMethods = "permissionspage")
	public void termspage() throws InterruptedException {
		// Terms and conditions page
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.Image"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
	}

	@Test(dependsOnMethods = "termspage")
	public void mobilenumberpage() throws InterruptedException {
		String number = RandomStringUtils.randomNumeric(7);
		Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).sendKeys("958" + number);
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Request OTP']")).click();
		// driver.quit();
	}

	@Test(dependsOnMethods = "mobilenumberpage")
	public void mobileotppage() throws InterruptedException {

		// mobile otp page
		Thread.sleep(1000);
		try {
			driver.findElement(By.className("android.widget.EditText")).click();
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.className("android.widget.EditText")).click();
		}

		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = "mobileotppage")
	public void setpinpage() throws InterruptedException {
		// Set pin page
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Set']")).click();

	}

	@Test(dependsOnMethods = "setpinpage")
	public void confirmpinpage() throws InterruptedException {

		// confirm pin page
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='1']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='2']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='3']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='4']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Confirm']")).click();
	}

	@Test(dependsOnMethods = "confirmpinpage")
	public void Eligibilitypage() throws InterruptedException {
		// Eligibility
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Start']")).click();
	}

	@Test(dependsOnMethods = "Eligibilitypage")
	public void Aadharpage() throws InterruptedException {
		// Aadhar page
		Thread.sleep(3000);
		try {
			driver.findElement(By.className("android.widget.EditText")).click();

		} catch (StaleElementReferenceException e) {
			driver.findElement(By.className("android.widget.EditText")).click();

		}
		aadharNum = RandomStringUtils.randomNumeric(10);
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View")).sendKeys("412369874563");
		driver.findElement(By.className("android.widget.EditText")).sendKeys("71" + aadharNum);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "Aadharpage")
	public void Aadharotppage() throws InterruptedException {
		// Aadhar otp page
		Thread.sleep(2000);
		try {
			// driver.findElement(By.xpath(
			// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View"))
			// .click();
			driver.findElement(By.className("android.widget.EditText")).click();
		} catch (StaleElementReferenceException a) {
			driver.findElement(By.className("android.widget.EditText")).click();
			// driver.findElement(By.xpath(
			// "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View"))
			// .click();
		}
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();

	}

	@Test(dependsOnMethods = "Aadharotppage")
	public void PANpage() throws InterruptedException {
		// PAN page
		Thread.sleep(4000);
		panChar = RandomStringUtils.randomAlphabetic(5);
		panNumber = RandomStringUtils.randomNumeric(4);
		panLastLetter = RandomStringUtils.randomAlphabetic(1);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys(panChar + panNumber + panLastLetter);
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "PANpage")
	public void selectaccountspage() throws InterruptedException {
		// select accounts page
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "selectaccountspage")
	public void bankotpverify() throws InterruptedException {
		// bank otp verify
		Thread.sleep(2000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).clear();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "bankotpverify")
	public void AddEmailpage() throws InterruptedException {

		// Add Email page
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		// driver.findElement(By.xpath("//android.widget.Image[@text='square
		// outline']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Add']")).click();
	}

	@Test(dependsOnMethods = "AddEmailpage")
	public void EmailVerificationpage() throws InterruptedException {

		// Email Verification Page
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("123456");
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Verify']")).click();
	}

	@Test(dependsOnMethods = "EmailVerificationpage")
	public void Addresspage() throws InterruptedException {
//Address page
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View"))
				.click();
		// driver.findElement(By.className("android.widget.Image")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Choose']")).click();
		Thread.sleep(3000);
	}

	@Test(dependsOnMethods = "Addresspage")
	public void selfiepage() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
//selfie page	
		Thread.sleep(3000);
		driver.findElement(By.id("com.sec.android.app.camera:id/center_button")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("com.sec.android.app.camera:id/stop_button_area")).click();
		Thread.sleep(4000);
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
	}

	@Test(dependsOnMethods = "selfiepage")
	public void Labelloanpage() {
//Label loan page
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Home loan");
		driver.findElement(By.id("image")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT']")).click();
	}

	@Test(dependsOnMethods = "Labelloanpage")
	public void selectplan() throws InterruptedException {
//select plan
		Thread.sleep(6000);

		// manually operated seekbar for amount and tenure selection

		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
		driver.quit();
	}

	@Test(dependsOnMethods = "selectplan")
	public void Occupationpage() throws InterruptedException {

		// Occupation page
		// occupation dropdown
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Occupation chevron down']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Lawyer']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Occupation close']")).click();
		// Income dropdown
		driver.findElement(By.xpath("//android.widget.Button[@text='Income chevron down']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='₹20,000-₹50,000']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Income close']")).click();
		// Education dropdown
		driver.findElement(By.xpath("//android.widget.Button[@text='Education chevron down']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Professional']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Education close']")).click();
		driver.findElement(By.id("keyButton")).click();

	}

	@Test(dependsOnMethods = "Occupationpage")
	public void proofofincomepage() throws InterruptedException {

		// proof of income page
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.CompoundButton[4]"))
				.click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Adobe Scan 16-Aug-2023.pdf']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "selectplan")
	public void eNACHagreementpage() throws InterruptedException {
		// eNACH agreement page
		try {
			driver.findElement(By.xpath("//android.widget.Image[@text='square outline']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//android.widget.Image[@text='square outline']")).click();
		}
		Thread.sleep(1000);
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(1000);

	}

	@Test(dependsOnMethods = "eNACHagreementpage")
	public void Depositaccountpage() throws InterruptedException {

		// Deposit account page
		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.Image"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
	}

	@Test(dependsOnMethods = "Depositaccountpage")
	public void Paymentpage() throws InterruptedException {
		// Payment page
		Thread.sleep(2000);
		// debit card checkbox
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		driver.findElement(By.xpath("//android.widget.Button[@text='Pay EMI arrow up outline']")).click();
	}

	@Test(dependsOnMethods = "Paymentpage")
	public void DebitCarddetails() throws InterruptedException {
		// Debit Card details
		Thread.sleep(2000);
		// select available card
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button[1]")).click();
		// driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Image")).click();
		debitcardnumber = RandomStringUtils.randomNumeric(12);
		driver.findElement(By.className("//android.widget.EditText")).click();
		driver.findElement(By.className("//android.widget.EditText")).sendKeys(debitcardnumber);
		Name = RandomStringUtils.randomAlphabetic(10);
		driver.findElement(By.className("//android.widget.EditText")).click();
		driver.findElement(By.className("//android.widget.EditText")).sendKeys(Name);
		Expdate = RandomStringUtils.randomNumeric(5);
		driver.findElement(By.className("//android.widgeitText")).click();
		driver.findElement(By.className("//android.widget.EditText")).sendKeys(Expdate);
		cvv = RandomStringUtils.randomNumeric(3);
		driver.findElement(By.className("//android.widget.EditText")).click();
		driver.findElement(By.className("//android.widget.EditText")).sendKeys(cvv);

		driver.findElement(By.xpath("//android.widget.Button[@text='Pay arrow up outline']")).click();
	}

	@Test(dependsOnMethods = "DebitCarddetails")
	public void Alldonepage() {
		// All done page
		driver.findElement(By.xpath("//android.widget.Button[@text='Dashboard']")).click();

		System.out.println("User mobile number:" + "958" + number);
		System.out.println("User aadhar number:" + aadharNum);
		System.out.println("User pan number:" + panChar + panNumber + panLastLetter);
		System.out.println("User Debitcard number:" + debitcardnumber);
		System.out.println("User Debitcard number:" + debitcardnumber);
		System.out.println("User Name:" + Name);
		System.out.println("User Expdate:" + Expdate);
		System.out.println("User cvv:" + cvv);
	}

	@Test(dependsOnMethods = "Alldonepage")
	public void Dashboardpage() throws InterruptedException {
		// Dashboard page
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Image"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='back']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.Image"))
				.click();
		Thread.sleep(1000);
		// logout
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.widget.Button"))
				.click();
	}

}
