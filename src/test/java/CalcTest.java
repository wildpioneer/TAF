import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest {

    private Calculator calc = new Calculator("CalcTest");

    @Test (description = "Critical Path")
    public void testSum() {
        Assert.assertEquals(5, calc.sum(2, 3));
    }

    @Test
    public void testSum1() {
        Assert.assertEquals(5, calc.sum(2, 3));
    }

    @Test
    public void testSum2() {
        Assert.assertEquals(6, calc.sum(2, 3));
    }
}
