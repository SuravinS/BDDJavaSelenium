package com.bbc.sounds.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbc.sounds.pageobjects.HomePage;
import com.bbc.sounds.pageobjects.StationsPage;
import com.bbc.sounds.utils.PropertiesReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StationSteps {

	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;

	public StationSteps() throws Exception {

		PropertiesReader propertiesReader = new PropertiesReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	@When("^I click the ‘View all Stations & Schedules’ link$")
	public void i_click_the_view_all_stations_schedules_link() {
		try {
			HomePage home = new HomePage(driver, wait);
			home.clickViewAllStationsLink();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Then("^I am on the ‘Stations’ page$")
	public void i_am_on_the_stations_page() {
		try {
			StationsPage Stations = new StationsPage(driver, wait);
			Stations.stationPageIsDisplayed();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	@Then("^I see (\\d+) network station logos$")
	public void i_see_network_station_logos(String int1) {
		try {
			StationsPage Stations = new StationsPage(driver, wait);
			Stations.getStationLogoCount(Integer.parseInt(int1));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
