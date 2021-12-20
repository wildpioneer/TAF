import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
    private int attempt = 1;

    @Test (retryAnalyzer = Retry.class)
    public void flakyTest() {
        if (attempt == 4) {
            Assert.assertTrue(true);
        } else {
            attempt++;
            System.out.println(attempt);
            throw new NullPointerException();
        }
    }
}
