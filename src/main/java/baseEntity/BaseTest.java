package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public BrowsersService browsersService;
    public WebDriver driver;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        driver = browsersService.getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterClass
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}