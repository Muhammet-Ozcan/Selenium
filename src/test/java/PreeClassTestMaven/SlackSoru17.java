package PreeClassTestMaven;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SlackSoru17 extends TestBase {

    @Test
    public void example() {
        //Faker Kutuphanesi HOMEWORK
        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        Faker faker = new Faker();
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        WebElement createNewAccount = driver.findElement(By.xpath("(//*[@role='button'])[2]"));
        createNewAccount.click();
        //“firstName” giris kutusuna bir isim yazin
        WebElement firstNameLocate = driver.findElement(By.xpath("//*[@name='firstname']"));
        firstNameLocate.sendKeys(faker.name().firstName());
        //“surname” giris kutusuna bir soyisim yazin
        WebElement lastName = driver.findElement(By.xpath("//*[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());
        //“email” giris kutusuna bir email yazin
        WebElement eMail = driver.findElement(By.cssSelector("input[name='reg_email__']"));
        String fakeEmail = faker.internet().emailAddress();
        eMail.sendKeys(fakeEmail);
        //“email” onay kutusuna emaili tekrar yazin
        WebElement eMailTwo = driver.findElement(By.xpath("//*[@name='reg_email_confirmation__']"));
        eMailTwo.sendKeys(fakeEmail);
        //Bir sifre girin
        WebElement fakeSifre = driver.findElement(By.cssSelector("input[id='password_step_input']"));
        fakeSifre.sendKeys(faker.internet().password());
        //Tarih icin gun secin
        WebElement days = driver.findElement(By.id("day"));
        String daysValueof = String.valueOf(faker.number().numberBetween(1,31));
        days.sendKeys(daysValueof);
        //Tarih icin ay secin
        WebElement months = driver.findElement(By.id("month"));
        months.sendKeys("Ara");
        //Tarih icin yil secin
        WebElement years = driver.findElement(By.id("year"));
        String yearsValueOf =String.valueOf(faker.number().numberBetween(1905,2023));
        years.sendKeys(yearsValueOf);
        //Cinsiyeti secin
        WebElement manButton = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));
        manButton.click();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement womenButton = driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
        WebElement specialButton = driver.findElement(By.xpath("(//*[@name='sex'])[3]"));
        Assert.assertTrue(manButton.isSelected());
        Assert.assertFalse(womenButton.isSelected() && specialButton.isSelected());
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
    }
}
