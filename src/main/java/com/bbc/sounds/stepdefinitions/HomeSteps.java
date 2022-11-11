package com.bbc.sounds.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bbc.sounds.pageobjects.HomePage;
import com.bbc.sounds.utils.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {
	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;

	public HomeSteps() throws Exception {

		PropertiesReader propertiesReader = new PropertiesReader();
		this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
	}

	@Given("^that I am on the BBC Sounds Homepage$")
	public void that_i_am_on_the_bbc_sounds_homepage() {
		try {
			HomePage home = new HomePage(driver, wait);
			org.testng.Assert.assertTrue(home.homePageIsDisplayed());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@When("^I select the (.*) logo$")
	public void i_select_the_home_logo(String text) {
		try {
			HomePage home = new HomePage(driver, wait);
			home.selectHomeLogo();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Then("^I am on the Sounds Homepage$")
	public void i_am_on_the_sounds_homepage() {
		try {
			HomePage home = new HomePage(driver, wait);
			org.testng.Assert.assertTrue(home.homePageIsDisplayed());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Then("^I can see the Radio (\\d+) logo$")
	public void i_can_see_the_radio_logo(String int1) {
		try {
			HomePage home = new HomePage(driver, wait);
			home.checkRadioLogo(Integer.parseInt(int1));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@When("^I select Hip Hop, RnB & Dancehall Category$")
	public void i_select_hip_hop_rn_b_dancehall_category() {
		try {
			HomePage home = new HomePage(driver, wait);
			home.selectHipHopAndDancehall();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Then("^I am on ‘Hip Hop, RnB & Dancehall’ Category page$")
	public void i_am_on_hip_hop_rn_b_dancehall_category_page() {
		try {
			HomePage home = new HomePage(driver, wait);
			home.HipHopAndDancehallIsDisplayed();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Then("^I see the Category page is sorted by popular$")
	public void i_see_the_category_page_is_sorted_by_popular() {
		try {
			System.out.println("I see the Category page is sorted by popular");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
