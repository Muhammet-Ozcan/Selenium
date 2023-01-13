package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class SlackSoru18 extends TestBase {
    @Test
    public void example() {
        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");
        //anasayfada oldugunuzu dogrulayin
        WebElement iframe = driver.findElement(By.xpath("//*[@id='google_ads_iframe_/32607536/mainpage_masthead_0']"));
        driver.switchTo().frame(iframe);
        WebElement hemenBasvur = driver.findElement(By.xpath("//*[@class='video-bg']"));
        Assert.assertTrue(hemenBasvur.isEnabled());
        driver.switchTo().defaultContent();
        //detayli arama tiklayin
        WebElement detayliAramaLocate = driver.findElement(By.xpath("//*[@title='Detaylı Arama']"));
        detayliAramaLocate.click();
        //detayli arama sayfasina geldiginizi dogrulatin
        WebElement ilanTarihilocate = driver.findElement(By.xpath("//*[text()='İlan Tarihi']"));
        Assert.assertTrue(ilanTarihilocate.isDisplayed());
        //emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//*[text()='Emlak']")).click();
        driver.findElement(By.xpath("//*[text()='Konut']")).click();
        driver.findElement(By.xpath("//*[text()='Satılık']")).click();

        //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin

       ;


        //filtreler için sağıdakilere benzer methodlar oluşturun
        //detayli_Arama_Adres("izmir", "bayrakli", "adalet mah."
        navigasyon("Elazığ", "Keban","Fırat Mh.");
        // );
        //detayli_Arama_Fiyat("4.000","4.000.000","USD");
        money("1000","99999","USD");
        //detayli_Arama_Brut("180","400");
        //detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
        //.
        //.
        //...
        //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin*/


    }

    public void navigasyon(String il, String ilce, String semt) {
        WebElement ilClickLocate = driver.findElement(By.xpath("//*[@class='faceted-select']"));
        waitForVisibility(ilClickLocate, 10).click();
        WebElement ilSearch = driver.findElement(By.xpath("(//*[@class='js-address-filter'])[2]"));
        waitForVisibility(ilSearch, 10).click();
        ilSearch.sendKeys(il);
        driver.findElement(By.xpath("//a[.='"+il+"']")).click();


        WebElement ilceClickLocate = driver.findElement(By.xpath("(//*[@class='faceted-select'])[2]"));
        waitForVisibility(ilceClickLocate, 10).click();
        WebElement ilceSearch = driver.findElement(By.xpath("(//*[@class='js-address-filter'])[3]"));
        waitForVisibility(ilceSearch, 10).click();
        ilceSearch.sendKeys(ilce);
        WebElement ilceClick = driver.findElement(By.xpath("//a[@class='noChild facetedCheckbox' and  text()='"+ilce+"']"));
        waitForVisibility(ilceClick, 10).click();
        WebElement x1 = driver.findElement(By.xpath("//*[@class='collapse-pane']"));
        waitForVisibility(x1, 10).click();


        WebElement semtClickLocate = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        waitForVisibility(semtClickLocate, 10).click();
        WebElement semtSearch = driver.findElement(By.xpath("(//*[@class='js-address-filter'])[4]"));
        waitForVisibility(semtSearch, 10).click();
        semtSearch.sendKeys(semt);
        WebElement semtClick = driver.findElement(By.xpath("//a[@class=' facetedCheckbox' and text()='"+semt+"']"));
        waitForVisibility(semtClick,10).click();
        WebElement x2 = driver.findElement(By.xpath("//*[@class='collapse-pane']"));
        waitForVisibility(x2,10).click();

    }
    public void money(String minFiyat ,String maxFiyat , String paraBirimi){
     WebElement fiyat = driver.findElement(By.xpath("//*[@name='price_min']"));
     fiyat.sendKeys(minFiyat,Keys.TAB,maxFiyat,Keys.TAB,paraBirimi);
    }
}

