package net.bitacad.frontend;

import net.bitacad.frontend.selenium.SeleniumService;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = ("classpath:/cucumber.xml"))
@SpringBootTest(classes = CucumberFrontendIT.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingFrontendSteps {

    @Autowired
    private SeleniumService seleniumService;


    @Autowired
    protected WebDriver webDriver;
    private Scenario scenario;


    @Given("I open the page")
    public void iOpenThePage() throws Throwable {
        System.out.println("Open page");
        webDriver.get("http://www.google.com");
        assertTrue(false);
        /*
         if(!authenticated) {
            WebDriverWait wait = new WebDriverWait(webDriver, 20);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            authenticated = true;
            wait = new WebDriverWait(webDriver, 20);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("lastGenerated")));
        }
         */
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = seleniumService.getScreenshot();
            scenario.embed(screenshot, "image/png");
        }
    }

    @Then("^Something$")
    public void something() throws Throwable {
        System.out.println("Test");
    }

    @When("^I do nothing$")
    public void iDoNothing() throws Throwable {
        System.out.println("Test");
    }
}
