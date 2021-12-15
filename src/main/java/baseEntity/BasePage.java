package baseEntity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.techmeskills.auf.core.BrowsersService;
import org.techmeskills.auf.utils.Waiters;

public class BasePage {
    public WebDriver driver;
    public Waiters waiters;
    public BrowsersService browsersService;

    public BasePage(BrowsersService browsersService) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        this.waiters = browsersService.getWaiters();
    }

    public boolean isPageOpened(By by) {
        return waiters.waitForVisibility(by).isDisplayed();
    }
}