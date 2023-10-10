package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TermsandConditionsPage extends Basetestrocketfin{
	
	@Test(priority = 0)
	public void TermsandConditionsPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		// Get the actual title from the app
		String Expected_Result="Terms & Conditions";
		String Actual_Title = driver.findElement(By.xpath("//android.widget.TextView[@text='Terms & Conditions']")).getText();
		extentTest.info("Expected_Result:"+Expected_Result);
		extentTest.info("Actual_Result:"+Actual_Title);

		Assert.assertEquals(Actual_Title, "Terms & Conditions");

		}
		@Test(priority = 1)
		public void Nextbutton_WithoutInput() throws InterruptedException {

		Thread.sleep(3000);
		String Expected_Result="Next Button is disabled";
		extentTest.info("Expected_Result:Next button is disabled");
		boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).isEnabled();
		if (button == false) {
			extentTest.info("Actual_Result:Next button is disabled");
			} 	else {
				extentTest.info("Actual_Result:Next button is enabled");
				Assert.assertFalse(true);
			}
		}
		@Test(priority = 1,dependsOnMethods = "TermsandConditionsPageTitle")
		public void Checkbox1()throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"))
				.click();
		}
		@Test(priority = 2)
		public void Checkbox2()throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Image"))
				.click();
		}
		@Test(priority = 3)
		public void Checkbox3()throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.widget.Image"))
				.click();
		}
		@Test(priority = 4)
		public void Nextbutton_Withinput() throws InterruptedException {

			Thread.sleep(3000);
			String Expected_Result="Next Button is enabled";
			extentTest.info("Expected_Result:Next button is enabled");

			boolean button = driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).isEnabled();
			if (button == true) {
				extentTest.info("Actual_Result:Next button is enabled");
			} else {
				extentTest.info("Actual_Result:Next button is disabled");
				Assert.assertTrue(false);
			}
		}
		@Test(priority = 5)
		public void NextButton()throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
		String Expected_Result="Agreement accepted and saved successfully";
		extentTest.info("Expected_Result:"+Expected_Result);
		String Actual_Result= driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.TextView"))
				.getText();
		
		extentTest.info("Actual_Result:"+Actual_Result);
		}
}
