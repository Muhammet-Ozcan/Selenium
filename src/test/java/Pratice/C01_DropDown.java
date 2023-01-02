package Pratice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
public class C01_DropDown {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //** INTERVIEW QUESTION ** implicitlyWait() nereden gelir? -> Selenium
        //                         Thread.sleep() nereden gelir -> Java
    }
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        //1- Dropdown locate edilir
        WebElement ddMenu = driver.findElement(By.xpath("//select[@id='dropdown']"));
        //2- Select object'i olusturulur
        Select select = new Select(ddMenu);
        //3- Option secilir
        select.selectByIndex(1);
        String selectedOptionIndex = select.getFirstSelectedOption().getText();
        System.out.println("Secili Option : " + selectedOptionIndex);
        Thread.sleep(2500);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String selectedOptionValue = select.getFirstSelectedOption().getText();
        System.out.println("Secili Option : " + selectedOptionValue);
        Thread.sleep(2500);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String selectedOptionVisibleText = select.getFirstSelectedOption().getText();
        System.out.println("Secili Option : " + selectedOptionVisibleText);
        // Tüm option'ları yazdırın
        List<WebElement> allOptions = select.getOptions();
        int counter = 1;
        for (WebElement each : allOptions) {
            System.out.println(counter + ". Option " + each.getText());
            counter++;
        }
        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int expected = 3;
        int actual = allOptions.size();
        Assert.assertEquals(expected, actual);
    }
}