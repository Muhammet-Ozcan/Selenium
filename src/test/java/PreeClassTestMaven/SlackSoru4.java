package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SlackSoru4 {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test1() {
    //https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    //Dropdown Example menüsünün görünür olduğunu doğrulayın.
     WebElement menuDisplay = driver.findElement(By.xpath("//*[text()='Dropdown Example']"));
     Assert.assertTrue(menuDisplay.isDisplayed());
    //Option3 ü seçin.
     WebElement DropDownLocate =driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
     Select select = new Select(DropDownLocate);
     select.selectByVisibleText("Option3");
    //Option3 ün seçili olduğunu doğrulayın.
     String actualResult = select.getFirstSelectedOption().getText();
     String expectedResult ="Option3";
     Assert.assertEquals(actualResult,expectedResult);
    }


}
