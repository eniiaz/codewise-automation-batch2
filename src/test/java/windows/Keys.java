package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Keys {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");
        String mainWindowID = driver.getWindowHandle();
        System.out.println(mainWindowID);
        driver.findElement(By.id("opentab")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for (String id: windowHandles){
            if (!id.equals(mainWindowID)){
                driver.switchTo().window(id);
                break;
            }
        }
        System.out.println();
        System.out.println(driver.getCurrentUrl());

    }
}
