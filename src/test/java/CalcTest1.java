import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest1 extends BaseTest {

    private Calculator calc = new Calculator("CalcTest");

    @Test (invocationCount = 3, invocationTimeOut = 1000)
    public void testSum1() throws InterruptedException {
        Thread.sleep(250);
        Assert.assertEquals(5, calc.sum(2, 3));
    }

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void dataProviderTest(int a, int b, int expectedResult) throws InterruptedException {
        Assert.assertEquals(expectedResult, calc.sum(a, b));
        Thread.sleep(1000);
    }
}
