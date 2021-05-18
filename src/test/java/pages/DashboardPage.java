package pages;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;

public class DashboardPage extends HeaderPage {
    private String endpoint = "index.php?/dashboard";
    private static final By addProjectButton_By = By.id("sidebar-projects-add");

    public DashboardPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return browserService.getDriver().findElement(addProjectButton_By).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}
