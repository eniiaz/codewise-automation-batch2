package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cashwise {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cashwise.us");
        driver.manage().window().maximize();
        String expectedCashwiseTitle = "Cashwise is best!";
        String expectedCashwiseURL = "https://cashwise.us/home";

        if(driver.getTitle().equals(expectedCashwiseTitle)){
            System.out.println("Cashwise title passed");
        }else {
            System.out.println("Cashwise title failed");
        }
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());

        if (driver.getCurrentUrl().equals(expectedCashwiseURL)){
            System.out.println("Cashwise url passed");
        }else {
            System.out.println("Cashwise url failed");
        }

    }


}
