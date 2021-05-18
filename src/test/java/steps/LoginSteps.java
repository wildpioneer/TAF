package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.LoginPage;

public class LoginSteps extends BaseStep {
    private LoginPage loginPage;

    public LoginSteps(BrowserService browserService) {
        super(browserService);
    }

    public LoginSteps openLoginPage() {
        loginPage = new LoginPage(browserService, true);
        return this;
    }

    public LoginSteps loginWithIncorrectCredentials() {
        return this;
    }

    public DashboardSteps loginWithCorrectCredentials() {
        loginPage.getEmailInput().sendKeys("atrostyanko+0401@gmail.com");
        loginPage.getPasswordInput().sendKeys("QqtRK9elseEfAk6ilYcJ");
        loginPage.getLoginButton().click();

        return new DashboardSteps(browserService);
    }
}
