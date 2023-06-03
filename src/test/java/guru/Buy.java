package guru;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Buy {

    public String getInitials(String fullName){
        fullName = fullName.trim();
        if (fullName.isEmpty()){
            return null;
        }
        String [] arr = fullName.split(" ");
        if (arr.length != 2){
            return null;
        }
        String initials = "" + arr[0].charAt(0) + arr[1].charAt(0);
        return initials.toUpperCase();
    }

    @Test
    public void test1(){
        String actualResult = getInitials("james  bond");
        Assert.assertEquals("JB", actualResult);
    }

    @Test
    public void test2(){
        String result = getInitials("James");
        Assert.assertNull(result);
    }

    @Test
    public void test3(){
        String result = getInitials("james bond");
        Assert.assertEquals("JB", result);
    }

    @Test
    public void test4(){
        String result = getInitials("");
        Assert.assertNull(result);
    }

    @Test
    public void test5(){
        String result = getInitials("  john Doe ");
        Assert.assertEquals("JD", result);
    }

    @Test
    public void test6(){
        String result = getInitials("Cristiano Ronaldo Junior");
        Assert.assertNull(result);
    }
}
