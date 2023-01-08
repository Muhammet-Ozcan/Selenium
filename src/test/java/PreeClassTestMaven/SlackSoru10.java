package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class SlackSoru10 extends TestBase {
    @Test
    public void example() {

//https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com");
//Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//*[@class='card mt-4 top-card'])[3]")).click();
//""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement pagePrint = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        System.out.println(pagePrint.getText());
        Assert.assertTrue(pagePrint.isDisplayed());
//Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//*[@id='item-0'])[3]")).click();
//New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        Assert.assertTrue(newTabButton.isDisplayed());
//New Tab butonuna click yap
        String firstPageWindowHandle = driver.getWindowHandle();
        newTabButton.click();
//Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        List<String> windowsHashCodes = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsHashCodes.get(1));

        System.out.println(driver.findElement(By.xpath("//*[text()='This is a sample page']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='This is a sample page']")).isDisplayed());

//İlk Tab'a geri dön
        driver.switchTo().window(firstPageWindowHandle);
////New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButton2 = driver.findElement(By.xpath("//button[@id='tabButton']"));
        Assert.assertTrue(newTabButton2.isDisplayed());
    }

}
