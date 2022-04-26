package com.enginegroup.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.BeforeClass;
import java.util.logging.Logger;

public class SerenityTestHooks {
    @BeforeClass
    public static void setup() {
        Logger.getLogger("\n******* RUN STARTS " + new java.util.Date() + " *******************************");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        String currentFeature = scenario.getId().split(";")[0];
        System.out.println("\n" + scenario.getSourceTagNames() + " STARTED");
        System.out.println("FEATURE: " + currentFeature.replaceAll("-", " "));
        System.out.println("SCENARIO: " + scenario.getName());
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        System.out.println("STATUS: " + scenario.getStatus().name().toUpperCase());
    }
}