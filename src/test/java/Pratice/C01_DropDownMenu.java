package Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown(){
     // driver.close();
    }

    @Test
    public void test1() {
// https://www.amazon.com/ sayfasina gidin
   driver.get("https://www.amazon.com/");
// dropdown'dan "Books" secenegini secin
   WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
   Select select = new Select(ddm);
   select.selectByVisibleText("Books");
//select.selectByValue("search-alias=stripbooks-intl-ship");
// select.selectByIndex(5);

// arama cubuguna "Java" aratın
     driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);
// arama sonuclarinin Java icerdigini test edin
 String aramaSonucu =driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
 System.out.println(aramaSonucu);
 Assert.assertTrue(aramaSonucu.contains("java"));

    }


}
