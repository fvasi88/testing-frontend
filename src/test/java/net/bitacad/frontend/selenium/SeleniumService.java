package net.bitacad.frontend.selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumService {

    private static Logger LOGGER = LoggerFactory.getLogger(SeleniumService.class);

    @Autowired
    private WebDriver webDriver;

    public byte[] getScreenshot() {
        try {
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException | ClassCastException e) {
            LOGGER.error("Cannot take screenshot", e);
            return null;
        }
    }
}
