package tests;

import baseEntity.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Waits;

import java.util.concurrent.TimeUnit;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        WebElement uploadFile = driver.findElement(By.id("file-submit"));

        chooseFile.sendKeys("/Users/aleksandr/Downloads/image_2021_12_16T07_59_15_520Z.png");
        uploadFile.click();

        Waits waits = new Waits(driver);
        WebElement header = waits.waitForVisibility(By.xpath("//h3[. = 'File Uploaded!']"));
        WebElement fileName = waits.waitForVisibility(By.id("uploaded-files"));

        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(fileName.getText(), "image_2021_12_16T07_59_15_520Z.png");
    }
}
