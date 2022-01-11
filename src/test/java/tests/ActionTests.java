package tests;

import baseEntity.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTests extends BaseTest {

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(source, target) // Не работает в хроме
                .build()
                .perform();

        Thread.sleep(3000);
    }

    @Test
    public void actionTest2() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement target = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions
                //.moveToElement(target)
                .contextClick(target);

        actions
                .pause(5000)
                .clickAndHold().moveToElement(target);

        actions
                .build()
                .perform();

        Thread.sleep(5000);
    }
}
