package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase5 {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test1() {
     //1. Launch browser
     //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
     //3. Verify that home page is visible successfully
      WebElement homePagePrint =driver.findElement(By.xpath("(//*[@class='title text-center'])[1]"));
        Assert.assertTrue(homePagePrint.isDisplayed());
     //4. Click on 'Signup / Login' button
      WebElement loginButton  =driver.findElement(By.xpath("//*[text()=' Signup / Login']"));
      loginButton.click();
     //5. Verify 'New User Signup!' is visible
        WebElement newUserVisible  = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue( newUserVisible.isDisplayed());
      //6. Enter name and already registered email address
      //7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@placeholder='Name']")).sendKeys("Muhammet",  Keys.TAB,"ozcanmuhammet298@gmail.com",Keys.TAB,Keys.ENTER);
     //8. Verify error 'Email Address already exist!' is visible
       WebElement alreadyExist = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
       Assert.assertTrue(alreadyExist.isDisplayed());
    }
}
