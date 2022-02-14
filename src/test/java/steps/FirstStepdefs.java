package steps;

import baseEntity.BaseCucumberTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;

public class FirstStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    private LoginPage loginPage;

    public FirstStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Step
    @Given("browser is started")
    public void browserIsStarted() {
    }

    @Step
    @When("login page is opened")
    public void loginPageIsOpened() {
        loginPage = new LoginPage(baseCucumberTest.driver);
    }

    @Step
    @Then("username field is displayed")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
    }
}
