package steps;

import core.BrowsersService;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class FirstStepdefsSimple {
    private WebDriver driver;
    private LoginPage loginPage;

    @Step
    @Given("browser is started 1")
    public void browserIsStarted() {
        driver = new BrowsersService().getDriver();
    }

    @Step
    @When("login page is opened 1")
    public void loginPageIsOpened() {
        loginPage = new LoginPage(driver);
    }

    @Step
    @Then("username field is displayed 1")
    public void usernameFieldIsDisplayed() {
        Assert.assertTrue(loginPage.getEmailField().isDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
