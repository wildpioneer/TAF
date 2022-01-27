package tests.gui;

import io.qameta.allure.*;
import models.User;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class allureTest {

    @Test
    @Description("Some detailed test description")
    public void testName() {
        Assert.assertTrue(true);
    }

    @Test(description = "Human-readable test name")
    public void testDescription() {
        Assert.assertTrue(true);
    }

    @Test
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    public void testLink() {
        Assert.assertTrue(true);
    }

    @Test
    @Issue("123")
    @Issue("432")
    public void testIssue() {
        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("test-1")
    @TmsLink("test-2")
    public void testTMS() {
        Assert.assertTrue(true);
    }

    @Test
    public void createConfigFile() throws ConfigurationException, IOException {
        PropertiesConfiguration conf = new PropertiesConfiguration("environment.properties");
        conf.setProperty("key", "value");
        conf.save();
    }

    @Test
    public void stepTest() {
        User user = User.builder()
                .name("Ivanov")
                .password("ABC")
                .build();

        loginWith(user);
    }

    @Step("Type {user.name} / {user.password}.")
    public void loginWith(User user) {
        System.out.println("Username:" + user.getUsername());
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSomething() {
        Assert.assertTrue(true);
    }
}
