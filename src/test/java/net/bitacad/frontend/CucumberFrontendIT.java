package net.bitacad.frontend;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cucumber/frontend",
        format = {"pretty", "html:target/CucumberReports"},
        glue = "net.bitacad")
@SpringBootTest

public class CucumberFrontendIT {
}
