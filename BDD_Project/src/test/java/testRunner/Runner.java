package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {".\\src\\test\\java\\features"},
glue= {"stepDefinitons","hook"},
monochrome=true,
plugin= {"pretty",
		"html:target/cucumber.html",
		"json:target/cucumberjson.json"
		},
tags = "@SmokeTest",
dryRun = true
)


public class Runner extends AbstractTestNGCucumberTests
{

	
	
}
