package PreeClassTestJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class junitTest {


    @Before
    public void before1(){
        System.out.println("BEFORE1 METHODU ÇALIŞTI");
    }


    @After
    public void  After1(){
        System.out.println("AFTER1 METHODU ÇALIŞTI");
    }



    @Test
    public void test1 (){
        System.out.println("TEST 1 METHODU ÇALIŞTI");
    }


    @Test
    public void test2(){
        System.out.println("TEST 2 METHODU ÇALIŞTI");
    }



    @Test
    public void test3(){
        System.out.println("TEST 3 METHODU ÇALIŞTI");
    }


}
