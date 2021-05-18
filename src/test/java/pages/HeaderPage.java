package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class HeaderPage extends BasePage {
    private By administration_By = By.id("navigation-admin");
    private By dashboard_By = By.id("navigation-dashboard");


    public HeaderPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    public WebElement getAdministrationLink() {
        return browserService.getDriver().findElement(administration_By);
    }

    public WebElement getDashboardLink() {
        return browserService.getDriver().findElement(dashboard_By);
    }
}
