package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void test1 (){
      //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePageDisplayed  = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        Assert.assertTrue(homePageDisplayed.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginAccount = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginAccount.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("BlackGhost@gmail.com"); // kişisel e posta adrsi yazmadım bu bir random'dur kendi e postanızı
                                                                                                                              // ve şifrenizi yazarsanız yada geçerli bir e posta şifre hata almicaksınızdır.
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("79874.km");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInUsername = driver.findElement(By.xpath("//*[text()='Muhammet']"));
        Assert.assertTrue(loggedInUsername.isEnabled());
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement delete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(delete.isDisplayed());
    }

}
