package net.bitacad.frontend.selenium;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@Getter
public class SeleniumConfig {

//    @Value("${webdriver.chrome.driver}")
//    private String chromeWebdriverPath;

    @Bean
    public WebDriver webDriver() {
        String property = System.getProperty("webdriver.gecko.driver");
        if (property == null) {
            System.setProperty("webdriver.gecko.driver",
                               "src/test/resources/webdriver/gecko/win64/geckodriver0.23.exe");
        }
        FirefoxOptions firefoxProfile = new FirefoxOptions();

        firefoxProfile.addPreference("network.http.phishy-userpass-length", 255);
        WebDriver webDriver = new FirefoxDriver(firefoxProfile);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return webDriver;
    }
}
