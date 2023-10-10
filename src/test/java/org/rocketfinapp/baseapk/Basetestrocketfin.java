package org.rocketfinapp.baseapk;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Basetestrocketfin {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;

	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest extentTest;

	@BeforeSuite
	public void configureappium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\office\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.0.107").usingPort(4723).withTimeout(Duration.ofSeconds(400)).build();

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("samsung SM-M317F");
		options.setPlatformName("Android");
		options.setCapability("PlatformVersion", "12.0");
		// options.setApp("E:\\Mobile_testingAutomation\\baseapk\\src\\test\\java\\Resources\\base
		// (5).apk");
		//options.setApp("F:\\Mobile_testingAutomation\\baseapk\\src\\test\\java\\Resources\\base.apk");
		options.setApp("F:\\Mobile_testingAutomation\\baseapk\\src\\test\\java\\Resources\\base (3).apk");
		service.start();
		driver = new AndroidDriver(new URL("http://192.168.0.107:4723/"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		reports = new ExtentReports();
		reporter = new ExtentSparkReporter("./ExtentReports/TestResult.html");

		reports.attachReporter(reporter);

		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java version", System.getProperty("java.version"));

	}

	@BeforeTest
	public void getTheTestName(ITestContext context) {

		extentTest = reports.createTest(context.getName()).assignAuthor("Parthiban").assignCategory("TESTCASES")
				.assignDevice("ANDROID");
		;
	}

	@BeforeMethod
	public void verifyTheName(Method m) {

		extentTest.info(MarkupHelper.createLabel("<b>" + m.getName() + "</b>", ExtentColor.TEAL));

	}

	@AfterMethod
	public void checkStatus(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
			// extentTest.addScreenCaptureFromPath(Screenshot(result.getName()));
			extentTest.fail(result.getThrowable());
		}

	}

	@AfterSuite()
	public void tear_Down() {

		reports.flush();
		service.stop();
		driver.quit();

// to open the report file from the given path...
		try {
			Desktop.getDesktop().browse(new File("ExtentReports/TestResult.html").toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}