package com.bbc.sounds.stepdefinitions;

import com.bbc.sounds.utils.PropertiesReader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void openBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		PropertiesReader propertiesReader = new PropertiesReader();
		driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(PropertiesReader.getValue("url"));
	}

	@After
	public void embedScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			try {
				captureScreen(driver);
				driver.quit();
			} catch (WebDriverException | IOException noSupportScreenshot) {
				System.err.println(noSupportScreenshot.getMessage());

			}

		} else {
			driver.quit();
		}

	}

	public void captureScreen(WebDriver driver) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
		Date date = new Date();
		String screenName = dateFormat.format(date);
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);

		File file = new File("src/main/resources/screenshots/");

		File target = new File(file.getAbsolutePath() + "/screenshots" + screenName + ".png");
		FileUtils.copyFile(src, target);

	}

}
