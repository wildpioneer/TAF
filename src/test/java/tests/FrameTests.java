package tests;

import baseEntity.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        //driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr");
        Assert.assertTrue(driver.findElement(By.id("tinymce")).isDisplayed());

        driver.switchTo().parentFrame();
        Assert.assertTrue(driver.findElement(By.className("tox-editor-container")).isDisplayed());

    }
}
