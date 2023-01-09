package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SlackSoru15 extends TestBase {
   @Test
   public void example(){
       //Bir Class olusturalim KeyboardActions2
       //https://html.com/tags/iframe/ sayfasina gidelim
       driver.get("https://html.com/tags/iframe");
       //video’yu gorecek kadar asagi inin
       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
       //videoyu izlemek icin Play tusuna basin
       WebElement iframeLocate = driver.findElement(By.xpath("//*[@width='560' and @height='315']"));
       driver.switchTo().frame(iframeLocate);
       WebElement playButton = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
       waitFor(2);
       playButton.click();
       playButton.getAttribute("");
       //videoyu calistirdiginizi test edin
       WebElement volumeButton = driver.findElement(By.xpath("//*[@class='ytp-mute-button ytp-button']"));
       Assert.assertTrue(volumeButton.isDisplayed());

   }
}
