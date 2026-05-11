package ProyectoBanca.Base.Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "classpath:features/login.feature", 
		    glue = "ProyectoBanca.Base.StepDefinitions",
		    plugin = {"pretty", "html:target/cucumber-report.html"},
		    monochrome = true,
			    tags = "@tag1"                              // Filtra por tag 
)
public class TestRunner {
}


