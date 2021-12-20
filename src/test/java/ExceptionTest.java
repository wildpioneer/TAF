import org.testng.annotations.Test;

import java.util.List;

public class ExceptionTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void testNPE() {
        List list = null;
        int size = list.size();
    }

    @Test(enabled = false)
    public void enableTest() {
        System.out.println("Test is disabled...");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(1001);
    }
}
