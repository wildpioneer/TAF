import org.testng.annotations.Test;

public class GroupsTest {

    @Test(groups = {"user1", "user2"})
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @Test(groups = "user1")
    public void testMethod2() {
        System.out.println("testMethod2");
    }

    @Test(groups = "user1")
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    @Test(groups = "user2")
    public void testMethod4() {
        System.out.println("testMethod4");
    }
}
