package HandleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PreeC3_DropDownAmazon {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(" https://www.amazon.com");
    }


    @Test
    public void test1(){

    WebElement dropDownList =driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
    Select select = new Select(dropDownList);
    List <String> kategoriler = new ArrayList<>();
    List <WebElement> kategorilerReferance =select.getOptions();
    for (WebElement w: kategorilerReferance){
        System.out.println(w.getText());
       kategoriler.add(w.getText());
    }

    String expectetResult = "45";
    String actualResult = String.valueOf(kategoriler.size());
    System.out.println("///////////////******//////////////\n");
    if (expectetResult.equals(actualResult)){
        System.out.println("expectetResult" +expectetResult + " : TEST PASSED");
    }else{
        System.out.println("ActualResult\t"+actualResult+": TEST FAIELD");
    }
    }

    @Test
    public void test2() {
        WebElement kategori = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(kategori);
        select.selectByVisibleText("Books");
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("java", Keys.ENTER);

        WebElement sonucSayisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String actualResult = sonucSayisi.getText();
        String expectedResult = "java";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //Otomasyon adimlari nelerdir?
        //1) Test kabul kriterleri dikkatlice okunur
        //2) Test case olusturulur
        //3) İlk once manuel test edilir
        //4) Her sey yolundaysa, otomasyon senaryolarinin testi yapilir
        //5) Hata ya da eksiklik varsa developerla konusulur, developer (gelistirici) sorunu duzelttiginde tekrar test edilir
        //6) Otomasyon testi tamamlandiginda konuyla ilgili rapor hazirlanir
        //i) Html raporu olusturulur
        //ii) Raporlar Jıra ya yuklenir
        //iii)Rapor hazırlarken, manuel testler icin ek Rapor hazırlanip JIRA'ya yuklenir
        //Test FAIL durumunda;
        //Basarisiz olmasinin nedeni ya veri ya da bug(hata) olabilir
        //Hatadan emin olmak icin yeniden test edilir
        //Eger bug kaynakli ise developerlarla konusulur ve  hatalari duzeltmeleri icin sure verilir
        //Hata duzeltildiginde tekrar test edilir ve rapor JIRA ya yuklenir
    }
}





















