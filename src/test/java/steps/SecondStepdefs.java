package steps;

import baseEntity.BaseCucumberTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class SecondStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseUtil;

    public SecondStepdefs(BaseCucumberTest baseUtil) {
        this.baseUtil = baseUtil;
    }

    @When("user logged in")
    public void userLoggedIn() {
        LoginPage loginPage = new LoginPage(baseUtil.driver);
        loginPage.login("atrostyanko+0401@gmail.com", "QqtRK9elseEfAk6ilYcJ");
    }

    @Then("add project button is displayed")
    public void addProjectButtonIsDisplayed() {
        DashboardPage dashboardPage = new DashboardPage(baseUtil.driver);
        Assert.assertTrue(dashboardPage.getAddProjectButton().isDisplayed());
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        LoginPage loginPage = new LoginPage(baseUtil.driver);
        loginPage.login(username, password);
    }

    @And("username is {string}")
    public void usernameIs(String text) {
        Assert.assertEquals(new DashboardPage(baseUtil.driver).getVisibleUsername(), text);
    }
}
