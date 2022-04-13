import org.testng.annotations.*;

@Listeners(Listener.class)
public class BaseTest {
    // Before Annotations
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: ");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: ");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups: ");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: ");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: ");
    }

    // After Annotations
    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: ");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: ");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("AfterGroups: ");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: ");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: ");
    }
}
