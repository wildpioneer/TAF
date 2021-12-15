package baseEntity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageOpened(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }

    }
}