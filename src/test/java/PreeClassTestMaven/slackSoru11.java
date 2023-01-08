package PreeClassTestMaven;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class slackSoru11 extends TestBase {
    @Test
    public void example() {
        //Go to https://www.amazon.com.tr/
        driver.get("https://www.amazon.com.tr");
        //Search iPhone13 512
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("iPhone13 512", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).sendKeys(Keys.ENTER); //Cookies
        //Check that the results are listed
        List<WebElement> iphone13List = driver.findElements(By.xpath("//*[@class='s-image']"));
        //Click iPhone13 at the top of the list
        WebElement firstIphone13 = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        firstIphone13.click();
        //Log the following values for each size .Size information .Price .Color .Stock status
        WebElement markaAndModel = driver.findElement(By.xpath("//*[@id='productTitle']"));
        String telephoneField[] = markaAndModel.getText().split(" ");
        System.out.println(Arrays.toString(telephoneField) + "\n");

        WebElement fiyatLocate = driver.findElement(By.xpath("(//*[@class='a-price-whole'])[1]"));
        String fiyat = fiyatLocate.getText();

        String stock = driver.findElement(By.xpath("//*[text()='    Stokta var.   ']")).getText();

        System.out.println("Marka : " + telephoneField[0] + "\nModel : " + telephoneField[1] + " " + telephoneField[2] + "\nSize : " + telephoneField[3] + " " +
                telephoneField[4] + "\nPrice : " +fiyat +  "\nColor : " + telephoneField[6] + " " + telephoneField[7] + "\nstock Durumu : " + stock);
        //Isim - Renk - Stok - Boyut - Fiyat

    }
}
