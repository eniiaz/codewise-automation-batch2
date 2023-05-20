package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Charger {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/");
        String firstWindowID = driver.getWindowHandle();

        driver.findElement(By.linkText("PRACTICE")).click();

        Set<String> handles = driver.getWindowHandles();
        for (String id: handles){
            if (!id.equals(firstWindowID)){
                driver.switchTo().window(id);
                break;
            }
        }
        String secondWindowID = driver.getWindowHandle();

        driver.findElement(By.id("opentab")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String id: windowHandles){
            if (!id.equals(firstWindowID) && !id.equals(secondWindowID)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.switchTo().window(secondWindowID);
        driver.close();
        System.out.println(driver.getCurrentUrl());
    }
}
