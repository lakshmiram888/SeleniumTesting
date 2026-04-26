package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/login.feature", glue = {"org.example.stepDefinitions"},
        dryRun = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class Runner {

}
