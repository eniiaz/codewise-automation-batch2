package guru;

import org.junit.*;

public class Ann {

    @BeforeClass
    public static void classBefore(){
        System.out.println("One time in the beginning");
    }

    @AfterClass
    public static void end(){
        System.out.println("One time in the end");
    }

    @Before
    public void setup(){
        System.out.println("Setup here");
    }

    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
        Assert.fail();
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
    }

    @After
    public void cleanup(){
        System.out.println("Clean up");
    }
}
