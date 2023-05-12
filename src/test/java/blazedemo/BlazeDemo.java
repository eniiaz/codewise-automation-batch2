package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BlazeDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();

        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[2]/div/p"));
        System.out.println(elements.size());
        System.out.println(elements.get(0).getText());
        System.out.println(elements.get(1).getText());
        driver.findElement(By.xpath("//h1/../p/a")).click();
    }
}
