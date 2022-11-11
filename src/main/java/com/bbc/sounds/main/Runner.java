package com.bbc.sounds.main;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/SoundsHomePage.feature", glue = {
		"com/bbc/sounds/stepdefinitions" })
public class Runner extends AbstractTestNGCucumberTests {

}
