package recorridoTestPlussChile;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("recorridoTestPlussChile")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-reports/cucumber.json", "pretty","html:target/site/cucumber-pretty.html"},
        stepNotifications = true,
        publish = true,
        features = {"src/test/resources/recorridoTestPlussChile"},
        glue = {"classpath:recorridoTestPlussChile.stepdefinition"},
        tags = "@buscarViaje"
)
public class RunCucumberTest {
}
