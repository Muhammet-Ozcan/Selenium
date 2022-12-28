package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class TekrarTesti1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //C01_TekrarTesti isimli bir class olusturun
        //2 https://www.google.com/ adresine gidin
         driver.get("https://www.google.com");
        //3 cookies uyarisini kabul ederek kapatin

        //4 Sayfa basliginin "Google" ifadesi icerdigini test edin

         String actualResult = driver.getTitle();
         String expectedResult = "Google";

         if (actualResult.contains(expectedResult)){
             System.out.println("TEST PASSED");
         }else {
             System.out.println("TEST FIELD");
         }

        //5 Arama cubuguna "Nutella" yazip aratin

         WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
         aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //6 Bulunan sonuc sayisini yazdirin

         WebElement aramaSonucu = driver.findElement(By.xpath("//*[@id='result-stats']"));

         String NutellaSayisi  =aramaSonucu.getText();


        //7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin


        String[] array = NutellaSayisi.split(" ");

        String str = array[1];

        String newSonuc = str.replaceAll("\\D","");

        Integer donusum = Integer.valueOf(newSonuc);

        if (donusum>10000000){
            System.out.println(donusum+"\t: 10000000'den Fazla");
        }else {
            System.out.println("10000000'dan az");
        }
        //8 Sayfayi kapatin

        driver.close();



    }
}
