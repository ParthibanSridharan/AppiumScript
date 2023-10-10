package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EligibilityPage extends Basetestrocketfin{
	
	@Test(priority = 0)
	public void EligibilityPageTitle() throws InterruptedException {
		Thread.sleep(1000);
		// Get the actual title from the app
		String actualTitle = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView")).getText();
		extentTest.info(actualTitle);

		Assert.assertEquals(actualTitle, "Eligibility");

	}
	@Test(priority = 1)
	public void EligibilityPageContents() throws InterruptedException {
		Thread.sleep(1000);
		// Get the actual title from the app
		String thankscontent = driver.findElement(By.xpath("//android.widget.TextView[@text='Thanks for signing up. Please keep the following documents ready and check your eligibility to proceed...']")).getText();
		extentTest.info(thankscontent);

		Assert.assertEquals(thankscontent, "Thanks for signing up. Please keep the following documents ready and check your eligibility to proceed...");

	}
	public void EligibilityContents() throws InterruptedException {
		Thread.sleep(1000);
		// Get the actual title from the app
		String Eligibilitycontent = driver.findElement(By.xpath("//android.widget.TextView[@text='Eligibility']")).getText();
		extentTest.info(Eligibilitycontent);

		Assert.assertEquals(Eligibilitycontent, "Eligibility");

	}
	public void DocumentsRequiredContents() throws InterruptedException {
		Thread.sleep(1000);
		// Get the actual title from the app
		String Documentsrequiredcontent = driver.findElement(By.xpath("//android.widget.TextView[@text='Eligibility']")).getText();
		extentTest.info(Documentsrequiredcontent);

		Assert.assertEquals(Documentsrequiredcontent, "Eligibility");
	
	}
	@Test(priority = 2)
	public void StartButton() throws InterruptedException {
	Thread.sleep(1000);
	// Get the actual title from the app
	boolean startbutton = driver.findElement(By.xpath("//android.widget.Button[@text='Start']")).isDisplayed();
	if (startbutton == true) {
		extentTest.info("button is enabled");
	} else {
		extentTest.info("button is disabled");
		Assert.assertTrue(false);
	}
}
	@Test(priority = 3)
	public void StartButtonclick() throws InterruptedException {

	driver.findElement(By.xpath("//android.widget.Button[@text='Start']")).click();
	}
	
	
}