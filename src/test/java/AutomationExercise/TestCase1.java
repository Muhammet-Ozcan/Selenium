package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.management.remote.MBeanServerForwarder;
import java.time.Duration;

public class TestCase1 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Test
    public void test1(){
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
    //3. Verify that home page is visible successfully
        WebElement sayfaErisimi = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(sayfaErisimi.isEnabled());
    //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup =driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());
    //6. Enter name and email address
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Muhammet");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("ozcanmuhammet298@gmail.com");
    //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement EnterAccountDisplayed =driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(EnterAccountDisplayed.isDisplayed());
    //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("145301.Mk");
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();

        WebElement day = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select select = new Select(day);
        select.selectByIndex(21);

        WebElement Month = driver.findElement(By.xpath("//select[@data-qa='months']"));
        Select select1 = new Select(Month);
        select1.selectByVisibleText("December");

        WebElement year = driver.findElement(By.xpath("//*[@data-qa='years']"));
        Select select2 = new Select(year);
        select2.selectByValue("2000");

    //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
    //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
   WebElement firsName = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
   firsName.sendKeys("Muhammet");

   WebElement lastName = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
   lastName.sendKeys("Özcan");

   WebElement company  = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
   company.sendKeys("Apple");

   WebElement adres1 = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
   adres1.sendKeys("Adana/Seyhan");

   WebElement adres2 = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
   adres2.sendKeys("Amerika/Florida");

   WebElement state = driver.findElement(By.xpath("(//input[@type='text'])[8]"));
   state.sendKeys("7658Sokak");

   WebElement city = driver.findElement(By.xpath("(//input[@type='text'])[9]"));
   city.sendKeys("Newyork");

   WebElement zipcode = driver.findElement(By.xpath("(//input[@type='text'])[10]"));
   zipcode.sendKeys("01010");

   WebElement mobileNumber = driver.findElement(By.xpath("(//input[@type='text'])[11]"));
   mobileNumber.sendKeys("05459877894");

   WebElement country =driver.findElement(By.xpath("//select[@data-qa='country']"));
   Select select3 = new Select(country);

    //13. Click 'Create Account button'
     driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
    //14. Verify that 'ACCOUNT CREATED!' is visible

    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button




    }

}
