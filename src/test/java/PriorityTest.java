import org.testng.annotations.Test;

public class PriorityTest {

    @Test (priority = 1)
    public void stepb() {
        System.out.println("Step 1...");
    }

    @Test (priority = 2)
    public void steps() {
        System.out.println("Step 2...");
    }

    @Test (priority = 2)
    public void stepa() {
        System.out.println("Step 3...");
    }

    @Test (priority = 2)
    public void stepc() {
        System.out.println("Step 4...");
    }
}
