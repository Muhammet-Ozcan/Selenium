package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUploadTest() {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFileButton = driver.findElement(By.xpath("//*[@id='file-upload']"));
        //Yuklemek istediginiz dosyayi secelim.
        String path = System.getProperty("user.home")+"\\Desktop\\logo.jpeg";
        String path2 = "C:\\Users\\Black\\Desktop\\logo.jpeg";
        String path3 ="C:\\Users\\Black\\Desktop\\logo.jpeg";
        //Upload butonuna basalim.
        chooseFileButton.sendKeys(path);
        //“File Uploaded!” textinin goruntulendigini test edelim.
    }

}
