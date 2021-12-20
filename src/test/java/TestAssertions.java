import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssertions {

    @Test
    public void softAsserts() {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("softAsserts method was started...");
        System.out.println("first assertion...");
        softAssert.assertTrue(true);
        System.out.println("second assertion...");
        softAssert.assertTrue(false);
        System.out.println("softAsserts method was failed...");
        softAssert.assertAll();
    }

    @Test
    public void hardAsserts() {
        System.out.println("hardAsserts method was started...");
        System.out.println("first assertion...");
        Assert.assertTrue(true);
        System.out.println("second assertion...");
        Assert.assertTrue(false);
        System.out.println("hardAsserts method was failed...");
    }
}
