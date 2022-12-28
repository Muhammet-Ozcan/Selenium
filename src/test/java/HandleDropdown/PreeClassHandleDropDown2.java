package HandleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.UnknownServiceException;
import java.time.Duration;

public class PreeClassHandleDropDown2 {
    WebDriver driver;

    @Before
    public void setup(){

     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.get(" http://zero.webappsecurity.com");
    }

    @Test
    public void test() throws InterruptedException {
    Thread.sleep(3000);
    WebElement signIn =driver.findElement(By.xpath("//*[@id='signin_button']"));
    signIn.click();
    WebElement login =driver.findElement(By.xpath("//*[@name='user_login']"));
    login.sendKeys("username");
    Thread.sleep(3000);
    WebElement password = driver.findElement(By.xpath("//input[@tabindex='2']"));
    password.sendKeys("password");
    Thread.sleep(3000);
    WebElement Signin  =driver.findElement(By.xpath("//*[@type='submit']"));
    Signin.click();
    Thread.sleep(3000);
    driver.navigate().back();
    WebElement onlineBanking =driver.findElement(By.xpath("//strong[text()='Online Banking']"));
    Thread.sleep(3000);
    onlineBanking.click();
    driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
    WebElement currency  = driver.findElement(By.xpath("//*[@id='pc_currency']"));
    Thread.sleep(3000);
    Select select = new Select(currency);
    select.selectByVisibleText("Eurozone (euro)");
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("98700");
    Thread.sleep(3000);
    WebElement usDollar =driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
    usDollar.isSelected();
    Assert.assertFalse(usDollar.isSelected());
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//label[@class='radio inline'])[3]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@value='Calculate Costs']")).click();
    driver.findElement(By.id("purchase_cash")).click();
    WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='alert_content']"));

        System.out.println(sonucYazisi.isDisplayed());

        Assert.assertTrue(sonucYazisi.isDisplayed());

    }
}
