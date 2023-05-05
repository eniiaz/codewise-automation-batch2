package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        String expectedGoogleTitle = "Hi, Google!";
        if (expectedGoogleTitle.equals(driver.getTitle())){
            System.out.println("Google title test is passed!");
        }else{
            System.out.println("Google title test is failed!");
        }
        driver.navigate().to("https://amazon.com");
        System.out.println(driver.getTitle());
        String expectedAmazonTitle = "Hey, Amazon!";
        if (expectedAmazonTitle.equals(driver.getTitle())){
            System.out.println("Amazon Title passed");
        }else {
            System.out.println("Amazon title failed");
        }
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit();
    }
}
