package testrunner;


import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;

//annotation tells about the test runner class to start executing our tests
@RunWith(Cucumber.class)	

// annotation is used to set some properties for our cucumber test like feature file
@CucumberOptions(features="src/test/resources/Features/mytest.Feature",glue={"StepDefinition"})						
public class runner 				
{		

}
