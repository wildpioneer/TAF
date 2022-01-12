package tests;

import baseEntity.BaseTest;
import core.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Retry;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginBtn.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        waits.waitForVisibility(dashboardPage.addProjectButton);

        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Test(retryAnalyzer = Retry.class)
    public void flakyLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.emailField.sendKeys(ReadProperties.getUsername());
        loginPage.passwordField.sendKeys(ReadProperties.getPassword());
        loginPage.loginBtn.click();

        DashboardPage dashboardPage = new DashboardPage(driver);
        waits.waitForVisibility(dashboardPage.addProjectButton);

        Assert.assertTrue(dashboardPage.isPageOpened());
    }
}
