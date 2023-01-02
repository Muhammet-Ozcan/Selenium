package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.Set;

public class SlackSoru7 extends TestBase {
    @Test
    public void example() {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com");
        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("//*[text()='Alerts, Frame & Windows']")).click();
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
         WebElement pagePrint = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']"));
         Assert.assertTrue(pagePrint.isDisplayed());
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();
        //New Tab butonunun görünür olduğunu doğrula
         WebElement newTab = driver.findElement(By.xpath("//*[@id='tabButton']"));
         Assert.assertTrue(newTab.isDisplayed());
         String firstPageHandle = driver.getWindowHandle();
        //New Tab butonuna click yap
          newTab.click();
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
         Set <String> hashCodes = driver.getWindowHandles();
         for (String hashCode: hashCodes){
             if (!hashCode.equals(firstPageHandle)){
                 driver.switchTo().window(hashCode);
             }
         }
         WebElement twoPage = driver.findElement(By.xpath("//*[text()='This is a sample page']"));
         Assert.assertTrue(twoPage.isDisplayed());
        //İlk Tab'a geri dön
        driver.switchTo().window(firstPageHandle);
        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTab2 = driver.findElement(By.xpath("//*[@id='tabButton']"));
        Assert.assertTrue(newTab2.isDisplayed());
    }
}