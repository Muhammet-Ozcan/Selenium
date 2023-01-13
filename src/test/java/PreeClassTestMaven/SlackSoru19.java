package PreeClassTestMaven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.time.Duration;

public class SlackSoru19 extends TestBase {

    @Test
    public void test() {
//      https://www.n11.com/ ' da
        driver.get("https://www.n11.com");
//      Decision table testing yaparak tum olasiliklar icin login page'in bize verecegi responselari test edin.
        WebElement loginLocate = driver.findElement(By.xpath("//*[@title='Giriş Yap']"));
        loginLocate.click();
//      n11ValidEmail=test.123.yap@gmail.com
//      n11ValidPassword=Deneme123!
        WebElement mailBox = driver.findElement(By.id("email"));
        mailBox.sendKeys("test.123.yap@gmail.com", Keys.TAB, "Deneme123!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Daha Sonra'])[1]")));
        driver.findElement(By.id("loginButton")).click();
    }
}
