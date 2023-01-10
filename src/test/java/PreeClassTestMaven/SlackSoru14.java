package PreeClassTestMaven;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class SlackSoru14 extends TestBase {


    @Test
    public void example() {
        //Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");
        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> dropDownList = select.getOptions();
        for (WebElement w : dropDownList) {
            System.out.println("Kategori : " + w.getText());
        }
        //dropdown menude 40 eleman olmadığını doğrulayın
        int listNumber = dropDownList.size();
        Assert.assertFalse(listNumber == 40);
    }

    //Test02
    @Test
    public void example2() {
        driver.get("https://www.amazon.com");
        //dropdown menuden elektronik bölümü seçin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Electronics");
        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        WebElement resultLetter = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("resultLetter : = " + resultLetter.getText());
        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedResult = "iphone";
        Assert.assertTrue(resultLetter.getText().contains(expectedResult));
        //ikinci ürüne relative locater kullanarak tıklayin
        WebElement twoPaint = driver.findElement(By.xpath("((//*[@class='a-section a-spacing-base'])[2]"));
        twoPaint.click();
        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        driver.findElement(By.xpath("(//*[@class='a-section a-spacing-base']//div//span//img)[2]")).click();
        String urunTitle = driver.getTitle();
        String urunFiyat = driver.findElement(By.xpath("(//div[@class='a-section dimension-slot-info']//span//span)[1] ")).getText();
        WebElement sepeteEkle = driver.findElement(By.xpath("add-to-cart-button"));
        sepeteEkle.click();
        System.out.println("Urun Title : " + urunTitle + "\n" + "Urun Fiyatı : " + urunFiyat);

    }

    //Test03
    //yeni bir sekme açarak amazon anasayfaya gidin

    @Test
    public void example3(){
        driver.get("https://www.amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Baby");
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset", Keys.ENTER);
        //sonuç yazsının puset içerdiğini test edin
        WebElement babySonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(babySonucYazisi.getText());
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement threePaint = driver.findElement(By.xpath("(//*[@class='s-product-image-container aok-relative s-image-overlay-grey s-text-center" +
                " s-padding-left-small s-padding-right-small s-flex-expand-height']//img)[3]"));
        threePaint.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        System.out.println(" Page Title : " + driver.getTitle() +"\n"+ "Urun fiyat : " + driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText());
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
