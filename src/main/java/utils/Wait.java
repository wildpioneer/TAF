package utils;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wrappers.UIElement;

public class Wait {
    private WebDriverWait webDriverWait;
    private BrowserService browserService;

    public Wait(BrowserService browserService) {
        this.browserService = browserService;
        this.webDriverWait = new WebDriverWait(browserService.getDriver(), ReadProperties.getTimeout());
    }

    public UIElement presenceOfElementLocated(By by) {
        return new UIElement(this.browserService, webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by)));
    }
}
