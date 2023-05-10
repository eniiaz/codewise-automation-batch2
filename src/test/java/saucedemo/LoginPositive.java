package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPositive {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)){
            System.out.println("Login successfully passed");
        }else {
            System.out.println("Login failed!");
        }
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
        Thread.sleep(500);
        driver.navigate().back();

        driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
        Thread.sleep(500);
        driver.navigate().back();

        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
        Thread.sleep(500);
        driver.navigate().back();

        driver.findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
        Thread.sleep(500);
        driver.navigate().back();
    }
}