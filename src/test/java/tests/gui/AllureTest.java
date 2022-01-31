package tests.gui;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureTest {

    @Test(description = "Human-readable test name")
    public void testName() {
        Assert.assertTrue(true);
    }

    @Test
    @Description("Some detailed test description")
    public void testDescription() {
        Assert.assertTrue(true);
    }

    @Test
    @Issue("PR-123")
    @Issue("PR-456")
    public void testIssue() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS-123")
    @TmsLink("TMS-456")
    public void testTMS() {
        Assert.assertTrue(true);
    }

    @Test
    @Link("https://example.org")
    @Link(name = "allureLink", type = "mylink", url = "https://onliner.by")
    public void testLink() {
        Assert.assertTrue(true);
    }
}
