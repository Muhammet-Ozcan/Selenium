package PraticeSelenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeOdev {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void example1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement IframeContainingText = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(IframeContainingText.isEnabled());
        System.out.println("Ana Sayfamdaki Yazı: \t" + IframeContainingText.getText());
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[@id='tinymce']")).sendKeys("Hello World");
        driver.switchTo().defaultContent();
        WebElement anaSayfa2 = driver.findElement(By.xpath("//*[@style='text-align: center;']"));
        Assert.assertTrue(anaSayfa2.isDisplayed());
        Thread.sleep(3000);
        System.out.println(anaSayfa2.getText());


    }

}
