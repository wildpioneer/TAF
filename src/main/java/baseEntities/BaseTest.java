package baseEntities;

import core.BrowserService;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Slf4j
public class BaseTest {
    public BrowserService browserService;

    @BeforeClass
    public void setupClass() {
        browserService = new BrowserService();
    }

    @AfterClass
    public void tearDownClass() {
        browserService.getDriver().quit();
    }
}
