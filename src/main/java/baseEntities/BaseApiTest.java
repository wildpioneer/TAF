package baseEntities;

import org.testng.annotations.BeforeTest;

public class BaseApiTest {

    @BeforeTest
    public void setupTest() {
        org.apache.log4j.BasicConfigurator.configure();
    }
}
