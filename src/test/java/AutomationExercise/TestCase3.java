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

public class TestCase3 {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test1() {
    //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
         driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
         WebElement CategoryDisplay =driver.findElement(By.xpath("//h2[text()='Category']"));
        Assert.assertTrue(CategoryDisplay.isDisplayed());
        //4. Click on 'Signup / Login' button
         WebElement loginButton  = driver.findElement(By.xpath("//*[@href='/login']"));
         loginButton.click();
        //5. Verify 'Login to your account' is visible
         WebElement loginAccountvisible  =driver.findElement(By.xpath("//*[@style='color: orange;']"));
         Assert.assertTrue(loginAccountvisible.isDisplayed());
        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("ozcanMuhammet@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("başaramamakYalnıiştır");
        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement inccorrect =driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue( inccorrect.isDisplayed());
    }
}
