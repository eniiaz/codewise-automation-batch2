package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Login {

    public static void main(String[] args) throws InterruptedException {
        // https://www.saucedemo.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("helloCodewise!");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password!");

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        String message = errorMessage.getText();
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        if (expectedErrorMessage.equals(message)){
            System.out.println("Error message passed");
        }else {
            System.out.println("Error message failed");
        }
        //driver.quit();
    }
}
