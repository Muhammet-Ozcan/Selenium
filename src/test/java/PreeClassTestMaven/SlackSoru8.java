package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class SlackSoru8 extends TestBase {
    @Test
    public void iframe() throws InterruptedException {
        // url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //       ilk pencereyi al
        String firstPageHashCode = driver.getWindowHandle();
        //       "Click Here" butonuna tıklayın
        driver.findElement(By.cssSelector("a[Style='font-size:16px;']")).click();
        //       setteki tüm pencereyi al
        Set<String> hashCodes = driver.getWindowHandles();
        //       diğer pencereye geç
        for (String w : hashCodes) {
            if (!w.equals(firstPageHashCode)) {
                driver.switchTo().window(w);
            }
        }
        //       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("somepne@gmail.com");
        //       Gönder düğmesine tıklayarak
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        //       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        WebElement tableOutput = driver.findElement(By.xpath("//h3"));

        Assert.assertEquals(tableOutput.getText(), "This access is valid only for 20 days.");
        //       Tekrar ilk pencereye geç
        Thread.sleep(3000);
        driver.switchTo().window(firstPageHashCode);
        //       İlk pencerede olduğunu doğrula
            WebElement isEnablePage = driver.findElement(By.cssSelector("a[style='font-size:16px;']"));
            Assert.assertTrue(isEnablePage.isEnabled());
    }
}
