package PraticeSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class HandleIframe extends TestBase {

    @Test
    public void iframe() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        driver.switchTo().frame(0); //her bir iframe tagı bir sayfaki her bir iframe'i temsil eder ve 1.iframe 0. indexdeki iframe'dır.
        // iframeleri handle ederken swithTo Method kullanırız SwitcTo alert de olduğu gibi iframe'dede iframein üzerine gider.
        String iframeStatus = driver.findElement(By.xpath("//*[@class='display-5 fw-bold']")).getText();
        System.out.println(iframeStatus);
        // String str = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        driver.switchTo().parentFrame(); // bir üsteki parent page'e gider
        // driver.switchTo().defaultContent(); bütün iframe'lerden çıkar en üsteki sayfaya gider.
        String iframeReturn = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']")).getText();// Not: ıframe girdikten sonra iframein üstündeki
        // sayfaya geri dönmek yani iframeden çıkmak zorudnayız
        System.out.println(iframeReturn);

    }
}
