package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logTest1() {
        logger.trace("Trace Message...");
        logger.debug("Debug Message...");
        logger.info("Info Message...");
        logger.error("Error Message...");
        logger.fatal("Fatal Message...");
    }
}
