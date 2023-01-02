package HandleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class dropdownmethod {

    WebDriver driver;
      @Before
      public void setup(){
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
      }


    public void selectFromDropdown(WebElement dropdown , String secenek) {

    List <WebElement> options = dropdown.findElements(By.tagName("option"));

    for (WebElement w: options){
        if (w.getText().equals(secenek)){
            w.click();
            break;
        }
    }
}

     @Test
     public void test1(){
        selectFromDropdown(driver.findElement(By.cssSelector("select[id='month']")), "January");

     }


}