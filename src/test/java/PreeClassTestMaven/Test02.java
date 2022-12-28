package PreeClassTestMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
         driver.get("http://zero.webappsecurity.com");
         Thread.sleep(3000);
        //2. Signin buttonuna tiklayin
        WebElement signin =driver.findElement(By.xpath("//*[@id='signin_button']"));
        signin.click();
        Thread.sleep(3000);
        //3. Login alanine “username” yazdirin
        WebElement login =driver.findElement(By.xpath("//*[@name='user_login']"));
        login.sendKeys("username");
        Thread.sleep(3000);
        //4. Password alanine “password” yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("password");
        Thread.sleep(3000);
        //5. Sign in buttonuna tiklayin
        WebElement SignInClick =driver.findElement(By.xpath("//*[@name='submit']"));
        SignInClick.click();
        Thread.sleep(3000);
        driver.navigate().back();
        //6. Pay Bills sayfasina gidin
        WebElement payBillsGo = driver.findElement(By.xpath("//*[@id='onlineBankingMenu']"));
        payBillsGo.click();
        Thread.sleep(3000);
        WebElement payBillsClick = driver.findElement(By.xpath("(//span[@class='headers'])[4]"));
        payBillsClick.click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount =driver.findElement(By.xpath("//*[@class='span1']"));
        amount.sendKeys("30000");
        Thread.sleep(3000);
        //8. tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.xpath("//*[@id='sp_date']"));
        date.sendKeys("2020-09-10");
        Thread.sleep(3000);
        //9. Pay buttonuna tiklayin
        WebElement pay  =driver.findElement(By.xpath("//*[@type='submit']"));
        pay.click();
        Thread.sleep(3000);
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj  =driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        String mesajGorundu =mesaj.getText();
        Thread.sleep(3000);
        boolean displayed =mesaj.isDisplayed();
        if (displayed){
            System.out.println(mesajGorundu+"\t TEST PASSED");
        }else{
            System.out.println("MESAJ GORUNTÜLENEMDİ TEST FAIELD");
        }
    }
}
