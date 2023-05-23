package iframe;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;
import java.util.List;

public class Local {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///Users/esen/Desktop/inventory.html");
        List<WebElement> texts = driver.findElements(By.xpath("//h1"));
        System.out.println(texts.size());
        System.out.println(texts.get(0).getText());

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[2]"));
        driver.switchTo().frame(secondFrame);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce" + Keys.ENTER);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("test");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(1500);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Thread.sleep(1500);
        alert.accept();

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 700).perform();
        Thread.sleep(3000);
        driver.switchTo().frame("courses-iframe");
        List<WebElement> menuList = driver.
                findElements(By.xpath("//div[@id='navbar-inverse-collapse']/ul//a"));
        System.out.println(menuList.size());
        Actions lastAction = new Actions(driver);
        for (WebElement menu: menuList){
            lastAction.moveToElement(menu).perform();
            Thread.sleep(800);
        }
    }
}
