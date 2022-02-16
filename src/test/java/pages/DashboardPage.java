package pages;

import baseEntity.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static final By PAGE_OPENED_IDENTIFIER = By.id("activityChart");
    private static String ENDPOINT = "/index.php?/dashboard";
    protected By addProjectButtonSelector = By.id("sidebar-projects-add");
    protected By USERNAME = By.className("navigation-username");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    @Override
    protected boolean isPageOpened() {
        return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonSelector);
    }

    public WebElement getUsernameLink() {
        return driver.findElement(USERNAME);
    }

    public String getVisibleUsername() {
        return getUsernameLink().getText();
    }

}
