package com.enginegroup.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/api/HappyPath.feature",
        glue = "src/test/java/com/enginegroup/stepdef/api")
public class SerenityAPITestRunner {
}