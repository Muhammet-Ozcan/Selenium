package PreeClassTestMaven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SlackSoru16 extends TestBase {
    @Test
    public void example(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirstButton = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        waitFor(2);
        actions.moveToElement(hoverOverMeFirstButton).perform();
        //3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"));
        link1.click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();
        //7- “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());
        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//*[@id='double-click']"))).perform();

    }
}
