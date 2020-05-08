package io.duotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith (Cucumber.class)
@CucumberOptions (
				  plugin = {"pretty",
						  "html:target/built-in-html-report", 
						  "json:target/Cucumber.json" 
				  },	
				  features = "@target/rerun.txt",
				  glue = "io/duotech/step_definitions"
				 
		)



public class FaildScenarioRunner {

}
