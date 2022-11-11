package com.bbc.sounds.pageobjects;

import com.bbc.sounds.utils.BaseClass;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StationsPage extends BaseClass {

	public StationsPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Stations']")
	@CacheLookup
	private WebElement ele_lblStations;

	@FindBy(xpath = "//div[@class='sc-o-responsive-image__overlay ']")
	@CacheLookup
	private WebElement ele_lblStationsLogos;

	public boolean stationPageIsDisplayed() {
		WaitUntilElementVisible(ele_lblStations);
		if (ele_lblStations.isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public int getStationLogoCount(int i) {
		WaitUntilElementVisible(ele_lblStationsLogos);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sc-o-responsive-image__overlay ']"));
		int elementsCount = elements.size();
		if (elementsCount == i) {
			System.out.println("Total Number of Stations equals to 26 ");
		} else {
			System.out.println("Total Number of Elements : " + elementsCount);
		}
		return elementsCount;
	}

}
