package com.bbc.sounds.pageobjects;

import com.bbc.sounds.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='sc-c-sounds-nav__brand-svg']")
	@CacheLookup
	private WebElement ele_logo;

	@FindBy(xpath = "//a[contains(@data-bbc-container,'index-home')]/span[text()='Home']")
	@CacheLookup
	private WebElement ele_home;

	@FindBy(xpath = "//div[text()='Radio 1']")
	@CacheLookup
	private WebElement ele_radioOneLogo;

	@FindBy(xpath = "//div[text()='Radio 2']")
	@CacheLookup
	private WebElement ele_radioTwoLogo;

	@FindBy(xpath = "(//span[text()='View all Stations & Schedules'])[1]")
	@CacheLookup
	private WebElement lnk_viewAllSatationsLink;

	@FindBy(xpath = "//h2[text()='Categories']//../..//div[text()='Hip Hop, RnB & Dancehall']")
	@CacheLookup
	private WebElement ele_CategoriesHipHopAndDancehall;

	@FindBy(xpath = "//h2[text()='Hip Hop, RnB & Dancehall']")
	@CacheLookup
	private WebElement ele_lblHipHopAndDancehall;

	public boolean homePageIsDisplayed() {
		WaitUntilElementVisible(ele_logo);
		ele_logo.isDisplayed();
		if (ele_logo.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void selectHomeLogo() {
		WaitUntilElementVisible(ele_home);
		ele_home.click();
	}

	public void checkRadioLogo(int i) {
		if (i == 1) {
			WaitUntilElementVisible(ele_radioOneLogo);
			ele_radioOneLogo.isDisplayed();
		} else if (i == 2) {
			WaitUntilElementVisible(ele_radioTwoLogo);
			ele_radioTwoLogo.isDisplayed();
		}

	}

	public void clickViewAllStationsLink() {
		WaitUntilElementVisible(lnk_viewAllSatationsLink);
		lnk_viewAllSatationsLink.click();
	}

	public void selectHipHopAndDancehall() {
		WaitUntilElementVisible(ele_CategoriesHipHopAndDancehall);
		ele_CategoriesHipHopAndDancehall.click();
	}

	public boolean HipHopAndDancehallIsDisplayed() {
		WaitUntilElementVisible(ele_lblHipHopAndDancehall);
		if (ele_lblHipHopAndDancehall.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}