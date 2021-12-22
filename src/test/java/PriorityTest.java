import org.testng.annotations.Test;

public class PriorityTest {

    @Test (priority = 1, description = "first test")
    public void stepb() {
        System.out.println("Step 1...");
    }

    @Test (priority = 2)
    public void steps() {
        System.out.println("Step 2...");
    }

    @Test (priority = 3)
    public void stepa11() {
        System.out.println("Step 3...");
    }

    @Test (priority = 3)
    public void stepa1() {
        System.out.println("Step 3...");
    }

    @Test (priority = 4)
    public void stepc() {
        System.out.println("Step 4...");
    }
}
