package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class test03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver =new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.xpath("(//*[@class='input_error form_input'])[1]"));
        userName.sendKeys("standard_user");

        //Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("secret_sauce");

        //. Login tusuna basin

        WebElement login =driver.findElement(By.xpath("//*[@type='submit']"));

        login.click();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement firstUrun = driver.findElement(By.xpath("(//*[@class='inventory_item_name'])[1]"));

        String firstUrunName =firstUrun.getText();
        System.out.println(firstUrunName);

        firstUrun.click();

        // Add to Cart butonuna basin
        WebElement addToCart =driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        addToCart.click();

        //Alisveris sepetine tiklayin

        WebElement alisverisSepeti =driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));

        alisverisSepeti.click();

        //Sectiginiz urunun basarili olarak sepete eklendigini control edin

         WebElement urunOnayi =driver.findElement(By.xpath("//*[@class='inventory_details_desc large_size']"));


    }
}
