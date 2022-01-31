package baseEntity;


import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADED_IN_SECONDS = 30;

    protected WebDriver driver;
    protected String BASE_URL;
    protected Waits waits;

    public BasePage(WebDriver driver) {
        this(driver, false);
    }

    public BasePage(WebDriver driver, boolean openPageByUrl) {
        this.driver = driver;
        this.waits = new Waits(driver);
        this.BASE_URL = ReadProperties.getUrl();

        if (openPageByUrl) {
            openPage();
        }

        waitForOpen();
    }

    protected abstract void openPage();

    protected abstract boolean isPageOpened();

    protected void waitForOpen() {
        int tryCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator
                && tryCount < (WAIT_FOR_PAGE_LOADED_IN_SECONDS / ReadProperties.getTimeOut())) {
            tryCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}