package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Enter {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
    }
}
