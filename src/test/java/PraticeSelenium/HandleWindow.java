package PraticeSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class HandleWindow extends TestBase {
    @Test
    public void example(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Windows");
        String firsPage = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@target='_blank']")).click();

        Set<String> hashCodes = driver.getWindowHandles();

        for (String w: hashCodes){
            if (!w.equals(firsPage)){
                driver.switchTo().window(w);
            }
        }
            String  nextPageTitle = driver.getTitle();
            Assert.assertEquals(nextPageTitle,"New Window");


    }
}
