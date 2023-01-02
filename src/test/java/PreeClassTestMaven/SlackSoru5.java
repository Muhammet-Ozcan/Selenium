package PreeClassTestMaven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class SlackSoru5 extends TestBase {

 @Test
 public void example(){
     //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis
     driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis");
     //maximize the web site
     // ikinci emojiye tıklayın
     driver.switchTo().frame(1);
     driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
     List<WebElement> animalsEmoji = driver.findElements(By.xpath("//img[@draggable='false']"));

     List<WebElement>suzgecEmoji;

     // ikinci emoji altındaki tüm öğelere tıklayın
     // ana iframe'e geri dön
     //formu doldurun,(Formu istediğiniz metinlerle doldurun)
     // uygula butonuna tıklayın
 }

}
