package PreeClassTestMaven;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class SlackSoru12CopyKısa extends TestBase {
    @Test
    public void test01() {
        driver.get(" http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions2 = new Actions(driver);
        for (int i = 1; i < 8; i++) {
            actions2.dragAndDrop(driver.findElement(By.id("box" + i)), driver.findElement(By.id("box10" + i))).perform();
        }
    }
}