package baseEntity;

import dataBaseService.DataBaseService;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseDBTest {
    public static Logger logger = Logger.getLogger(BaseDBTest.class);

    public DataBaseService dataBaseService;

    public BaseDBTest() {
    }

    @BeforeTest
    public void setupConnection() {
        org.apache.log4j.BasicConfigurator.configure();

        dataBaseService = new DataBaseService();
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }
}
