package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo  extends TestBase {


    @Test
    public void test1(){
        driver.get("https://www.techproeducation.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }
}
