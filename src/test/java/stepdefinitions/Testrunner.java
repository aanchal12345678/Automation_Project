package stepdefinitions;
import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import org.junit.platform.suite.api.*;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("feature/login.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "Stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/login-report.html")

public class Testrunner {
}











