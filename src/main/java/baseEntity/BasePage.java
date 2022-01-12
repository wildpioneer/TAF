package baseEntity;


import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public abstract class BasePage {
    protected WebDriver driver;
    protected Waits waits;
    protected String BASE_URL;

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
    }

    protected abstract void openPage();

    public boolean isPageOpened(By by) {
        try {
            return waits.waitForVisibility(by).isDisplayed();
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}