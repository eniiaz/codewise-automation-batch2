package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement male = driver.findElement(By.id("male"));
        WebElement automation = driver.findElement(By.className("Automation"));

        System.out.println("Before: " + male.isSelected());
        male.click();
        System.out.println("After: " + male.isSelected());

        System.out.println("Before: " + automation.isSelected());
        automation.click();
        System.out.println(automation.isSelected());

        // Continue the code and select female from gender radio button.
        // After selecting female check if male is unselected
        WebElement female = driver.findElement(By.id("female"));
        female.click();
        System.out.println("Check: " + male.isSelected());
        System.out.println(male.getAttribute("type"));

    }

}
