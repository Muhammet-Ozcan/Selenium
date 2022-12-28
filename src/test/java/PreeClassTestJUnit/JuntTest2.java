package PreeClassTestJUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JuntTest2 {

    @Test
    public void test1(){
        System.out.println("TEST1 METHODU ÇALIŞTI");
    }


    @BeforeClass
    public static void beforeclass1(){
        System.out.println("STATİC OLAN BEFORE CLASS METHODU ÇALIŞTI");
    }




    @AfterClass
    public static void afterClass1(){
        System.out.println("STATİC OLAN AFTER CLASS METHODU ÇALIŞTI");
    }


}
