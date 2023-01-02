package PraticeSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IframeOdevi extends TestBase {
    @Test
    public void iframeTest() {
//   1) https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
//   2) sayfadaki toplam iframe sayisini bulunuz.
        List <WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println(iframes.size());
//   3)Sayfa basliginda 'Editor' yazisini icerdigini test edelim.
      WebElement pageTitle  = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
      Assert.assertTrue(pageTitle.getText().contains("Editor"));
//   4)Prargraftaki yaziyi silelim
        driver.switchTo().frame(0);
        driver.findElement(By.className("mce-content-body")).clear();
//   5)Sonrasinda paragrafa "iframein icindeyim " yazisini yazdiralim
        driver.findElement(By.className("mce-content-body")).sendKeys("iframe'in içindeyim");
//   6)Alt kisimdaki yazinin 'Elemental Selenium' yazisini icerdigini test edelim
        driver.switchTo().defaultContent();
       WebElement anaSayfadakiYazi = driver.findElement(By.xpath("//*[@style='text-align: center;']"));
       Assert.assertTrue(anaSayfadakiYazi.isDisplayed());


    }
}