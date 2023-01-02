package AutomationExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase6 extends TestBase {

    @Test
    public void test1(){
      //. Launch browser
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
      //3. Verify that home page is visible successfully
       WebElement cartIsEnable =driver.findElement(By.xpath("(//*[@href='/view_cart'])[1]"));
       Assert.assertTrue(cartIsEnable.isEnabled());
      //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
      //5. Verify 'GET IN TOUCH' is visible
        WebElement GetInTouchDisplay = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(GetInTouchDisplay.isDisplayed());
      //6. Enter name, email, subject and message
       WebElement nameLocate =driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));
         nameLocate.sendKeys("Muhammet", Keys.TAB,"ozcanMuhammet298@gmail.com",Keys.TAB,"Bootcamp", Keys.TAB,
                 "Bootcampi Yoğun Başarılı bir şekilde bitirirsen Hayallerine kavuşursun");

      //7. Upload file
        WebElement FileSelect = driver.findElement(By.xpath("//*[@type='file']"));
       // FileSelect.sendKeys("\C:\\Users\\Black\\Desktop\\sampleFile.jpeg\"");

      //  driver.switchTo().alert().accept();
      //8. Click 'Submit' button
      //9. Click OK button
      //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
      //11. Click 'Home' button and verify that landed to home page successfully
    }
}
