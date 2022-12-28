package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class slackSoru {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        //driver.close();
    }

    @Test
    public void test1(){
      // ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        driver.findElement(By.xpath("//*[@class='form-control input-lg']")).sendKeys("phone" , Keys.ENTER);
        //    ~ get the brandName of phones
        WebElement telefon = driver.findElement(By.xpath("(//*[@href='http://tutorialsninja.com/demo/index.php?route=product/product&product_id=40&search=phone'])[1]"));
        System.out.println(telefon.getText());
        //    ~ click on add to button for all elements
        //    ~ click on black total added cart button
        //    ~ get the names of list from the cart
        //    ~ compare the names from displaying list and cart list

    }

}
