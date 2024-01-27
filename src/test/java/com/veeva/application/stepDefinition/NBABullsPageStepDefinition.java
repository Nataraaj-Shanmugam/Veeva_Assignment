package com.veeva.application.stepDefinition;

import com.veeva.application.pages.NBABullsPageActions;
import com.veeva.utility.ReporterUtilities;
import io.cucumber.java.en.Then;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Step definitions for scenarios dealing with the NBA Bulls page.
 * This class defines steps for various actions like navigating to the footer, getting links, and exporting data to CSV.
 */
public class NBABullsPageStepDefinition {

    private final NBABullsPageActions bullsPageActions = new NBABullsPageActions();

    /**
     * Navigates to the footer of the NBA Bulls page.
     */
    @Then("Navigate to footer")
    public void navigateToFooter(){
        bullsPageActions.scrollToFooter();
    }

    private HashMap<String, List<String>> hyperLink = null;

    /**
     * Retrieves all footer links from the NBA Bulls page.
     */
    @Then("Get all footer links")
    public void getLinks(){
        hyperLink = bullsPageActions.getAllLinks();
    }

    /**
     * Exports the retrieved footer links to a CSV file and attaches it to the Allure report.
     */
    @Then("Export to csv file")
    public void exportTOCSV(){
        bullsPageActions.generateCSV(hyperLink, "Hyperlinks.csv");
        ReporterUtilities.attachFileToAllureReport("Hyperlinks.csv", "Hyperlinks.csv");
    }
}
