package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test01 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 https://www.amazon.com/ sayfasina gidelim
         driver.get("https://www.amazon.com");
        //2 arama kutusunu locate edelim
         WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //3 “Samsung headphones” ile arama yapalim
         aramaKutusu.sendKeys("headphones", Keys.ENTER);
        //4 Bulunan sonuc sayisini yazdiralim
          WebElement aramaSonucu =driver.findElement(By.xpath("//span[text()='1-16 of over 10,000 results for']"));
          System.out.println(aramaSonucu.getText());
        //5 Ilk urunu tiklayalim
          WebElement firstpicture =driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
          firstpicture.click();
        //6 Sayfadaki tum basliklari yazdiralim


    }
}
