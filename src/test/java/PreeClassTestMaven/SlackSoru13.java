package PreeClassTestMaven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SlackSoru13 extends TestBase {

    @Test
    public void example(){
        // //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        //2. "Hover over Me First" kutusunun ustune gelin
        WebElement hoverOverMeFirst = driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirst).perform();
        waitFor(1);
        //3. "Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='dropdown-content'])[1]"));
        actions.click(link1).perform();
        //4. Popup mesajini yazdirin
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        waitFor(1);
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("clickAndHoldPrint = " + clickAndHold.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButton = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        waitFor(1);
        actions.doubleClick(doubleClickMeButton).perform();

        String attribute =doubleClickMeButton.getAttribute("class");
        System.out.println(attribute);
        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
    }
}
