package HandleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PreeClassHandleDropdown {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }


    @After
    public void Finish(){
        driver.quit();
    }


    @Test
    public void test1() throws InterruptedException {

        WebElement dropDownOption = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Thread.sleep(3000);
        Select select = new Select(dropDownOption);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(3000);
        Select select2 = new Select(dropDownOption);
        select2.selectByValue("2");
        String option2Print = select.getFirstSelectedOption().getText();
        System.out.println(option2Print);

        Thread.sleep(3000);
        Select select3 = new Select(dropDownOption);
        select3.selectByVisibleText("Option 1");
        System.out.println(select3.getFirstSelectedOption().getText());

        Thread.sleep(3000);

        Select select4 = new Select(dropDownOption);

        List<WebElement> dropDownList = select.getOptions();

        for (WebElement w : dropDownList) {
            System.out.println(w.getText());
        }
        System.out.println("************************\n");
    }

    @Test
    public void test2() {

        WebElement dropDownOption = driver.findElement(By.xpath("//*[@id='dropdown']"));

        Select select = new Select(dropDownOption);

        List<String> optionsSize = new ArrayList<>();

        List<WebElement> XXX = select.getOptions();

        for (WebElement w : XXX) {
            optionsSize.add(w.getText());
        }
        int listSize = optionsSize.size();
        String actualResult = String.valueOf(listSize);
        String ExpectedResult = "4";
        Assert.assertFalse(actualResult.contains(ExpectedResult));
    }

}























