package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Wait;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;
    private Wait wait;

    public BrowserService() {
        switch (ReadProperties.getBrowser().toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");

                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                break;
            default:
                log.error("Указан неверный тип браузера.");
                break;
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        this.wait = new Wait(this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Wait getWait() {
        return wait;
    }
}
