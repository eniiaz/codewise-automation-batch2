package timeouts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Etsy {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://etsy.com");
        driver.manage().window().maximize();
        WebElement search = driver.findElement(By.id("global--query"));
        search.sendKeys("Bracelet" + Keys.ENTER);
    }
}
