package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slacksoru12 extends TestBase {


    @Test
    public void example() {
        //#go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //#Fill in capitals by country


        WebElement washington = driver.findElement(By.xpath("(//div[@dragableelement='2'])[2]"));
        WebElement copenhagen = driver.findElement(By.xpath("(//div[@dragableelement='3'])[2]"));
        WebElement seoul = driver.findElement(By.xpath("(//div[@dragableelement='4'])[2]"));
        WebElement rome = driver.findElement(By.xpath("(//div[@dragableelement='5'])[2]"));
        WebElement madrid = driver.findElement(By.xpath("(//div[@dragableelement='6'])[2]"));
        WebElement stockholm = driver.findElement(By.xpath("(//div[@dragableelement='1'])[2]"));
        WebElement oslo = driver.findElement(By.xpath("(//div[@dragableelement='0'])[2]"));

        List<WebElement> capitalsList = new ArrayList<>(Arrays.asList(rome, madrid, oslo, copenhagen, seoul, stockholm, washington));

        List<WebElement> countrys = driver.findElements(By.cssSelector("div[class='dragableBoxRight']"));

        Actions actions = new Actions(driver);
        /*
        actions.dragAndDrop(capitalsList.get(0),countrys.get(0)).perform();
        actions.dragAndDrop(capitalsList.get(1),countrys.get(1)).perform();
        actions.dragAndDrop(capitalsList.get(2),countrys.get(2)).perform();
        actions.dragAndDrop(capitalsList.get(3),countrys.get(3)).perform();
        actions.dragAndDrop(capitalsList.get(4),countrys.get(4)).perform();
        actions.dragAndDrop(capitalsList.get(5),countrys.get(5)).perform();
        actions.dragAndDrop(capitalsList.get(6),countrys.get(6)).perform();
        */

        //Kısa Yol

        for (int i = 0; i < capitalsList.size(); i++) {
            actions.dragAndDrop(capitalsList.get(i), countrys.get(i)).build().perform();
        }
        //#url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        //#Ülkeye göre başkentleri doldurun
    }
}



