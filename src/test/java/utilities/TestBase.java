package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class  TestBase {

    // Utilities package'nın içindeki Test Base Classını yani şuan olduğum classı kod tekrarından kurtulmak için
    // her teste başlamadan önce driver'ı yükle sürücüyü tanıt maximize yap ve Duration.ofSeconds(20) gibi before notasyonunu burda oluşturuyorum.
    // After notasyonu oluşturup driver.quit , sürücüyü burda kapatıyorum ve test yaptığım yapacağım her classı bu classın(Test Base) Child'ı yani inheritance ilişkisi kurarak
    // Tekrar tekrar kod yazmak yerine bu classdan yararlanıyorum , inheritance ilişkisi olduğu için child classda Test'i Run ettiğim zaman parent Class'daki yani
    //(Test Base) methodlar otomatikmen çalışır bende test başında yapmam gerekenler otomatikmen gelir .

    // driver objesini olustur. Driver ya public yada protected olmali. Sebepi child classlarda gorulebilir olmasi

    protected static WebDriver driver;  // diğer package'larda kullanılacğı için protected veya Public olmalı.

    // setUp
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    //    tearDown
    @After
    public void tearDown(){
      //  driver.quit();
    }

    //    MULTIPLE WINDOW
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }



}
