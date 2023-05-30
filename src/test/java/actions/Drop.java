package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drop {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement link = driver.findElement(By.linkText("Selenium Sample Script"));
        WebElement textBox = driver.findElement(By.id("fname"));
        Thread.sleep(1500);

        WebElement link2 = driver.findElement(By.linkText("This is a link"));

        //actions.dragAndDrop(link, textBox).perform();
        actions.clickAndHold(link).moveToElement(link2).perform();
        Thread.sleep(5000);
    }
}
