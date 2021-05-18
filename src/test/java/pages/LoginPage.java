package pages;

import baseEntities.BasePage;
import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    private static final String endpoint = "index.php?/auth/login";

    private static final By loginButton_By = By.id("button_primary");
    private static final By emailInput_By = By.id("name");
    private static final By passwordInput_By = By.id("password");


    public LoginPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browserService.getDriver().get(ReadProperties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return browserService.getDriver().findElement(loginButton_By).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public Button getLoginButton() {
        return new Button(browserService.getWait().presenceOfElementLocated(loginButton_By));
    }

    public UIElement getEmailInput() {
        return browserService.getWait().presenceOfElementLocated(emailInput_By);
    }

    public UIElement getPasswordInput() {
        return browserService.getWait().presenceOfElementLocated(passwordInput_By);
    }
}

