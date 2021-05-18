package wrappers;

import core.BrowserService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class UIElement implements WebElement {
    private WebElement webElement;
    private Actions actions;
    private WebDriver webDriver;

    public UIElement(BrowserService browserService, By by) {
        this.webDriver = browserService.getDriver();
        this.webElement = webDriver.findElement(by);
        this.actions = new Actions(webDriver);
    }

    public UIElement(BrowserService browserService, WebElement webElement) {
        this.webDriver = browserService.getDriver();
        this.webElement = webElement;
        this.actions = new Actions(webDriver);
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (Exception ex) {
            actions
                    .moveToElement(webElement)
                    .click()
                    .build().perform();
        }
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
