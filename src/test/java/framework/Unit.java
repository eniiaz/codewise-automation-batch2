package framework;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Unit {

    @BeforeClass
    public static void b(){
        System.out.println("Before class");
    }
    @Before
    public void setup(){
        System.out.println("Setup");
    }
    @Test
    public void test2(){
        System.out.println("Test first");
    }

    @Test
    public void test1(){
        System.out.println("Test 2");
    }
}
