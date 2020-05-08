package io.duotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith (Cucumber.class)
@CucumberOptions (
				  plugin = { // "pretty",
						  "html:target/built-in-html-report",  //Where generats my html report
						  "json:target/Cucumber.json" // We are generats more nice and verbose report
				  },	
				  tags = "@smoke", //"@test1 and @smoke", //"@test1 or @smoke",
				  features = "src/test/resources/io/duotech/features",
				  glue = "io/duotech/step_definitions"
				  ,strict = true
		//		  ,dryRun = true
				  ,monochrome = true  //Gives more info in console resalt
				  ,stepNotifications = true  //Gives more info on JUnit console resalt
			//	  ,snippets = SnippetType.CAMELCASE
		)



public class CukeRunner {

}
