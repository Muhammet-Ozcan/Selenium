package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SlackSoru3 {



    @After
    public void setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://books-pwakit.appspot.com");

    }


    @Test
    public void test1(){

   //1-https://books-pwakit.appspot.com/ adresine gidin.
   //2-"BOOKS" başlığının görünür olduğunu doğrulayın

   //3-Arama çubuğunda "Selenium" u aratın.
   // 4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

    }

}
