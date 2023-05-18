package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Upload {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement uploadBtn = driver.findElement(By.id("file-upload"));
        Thread.sleep(1000);
        uploadBtn.sendKeys("/Users/esen/Downloads/deneme.txt");

        Thread.sleep(1000);
        driver.findElement(By.id("file-submit")).click();
    }
}
