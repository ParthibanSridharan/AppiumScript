package org.rocketfinapp.baseapk;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Homepage extends Basetestrocketfin {
	@Test(priority = 0)
	public void AllowPopupManagePhoneCalls() throws InterruptedException {
		// landing page->signup
		Thread.sleep(7000);
		String popup= driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).getText();
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		extentTest.info(popup+"is displayed");
	}
	@Test(priority = 1)
	public void mainpage() throws InterruptedException {
		Thread.sleep(3000);
		String StartButton=driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")).getText();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")).click();
		extentTest.info(StartButton);
	}
	@Test(priority = 2)
	public void Borrowerslide() throws InterruptedException {
		Thread.sleep(1000);
		String NextButton=driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")).getText();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button")).click();
		extentTest.info(NextButton);
	}
	@Test(priority = 3)
	public void Investorslide() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[4]")).click();
	}
	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Test(priority = 4)
	public void Chooseyourpath_slide() throws InterruptedException {
		Thread.sleep(3000);	
		@SuppressWarnings("deprecation")
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(306, 1978)).perform();
			
	}
}
