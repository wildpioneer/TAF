package steps;

import baseEntity.BaseCucumberTest;
import core.BrowsersService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest base;

    public Hook(BaseCucumberTest base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Opening the browser : Chrome");

        base.driver = new BrowsersService().getDriver();
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser");

        if (base.driver != null) {
            base.driver.quit();
        }
    }
}
