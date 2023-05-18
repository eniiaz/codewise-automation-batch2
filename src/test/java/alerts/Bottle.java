package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bottle {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement confirmAlertBtn = driver.findElement(By.xpath("//button[.='Generate Confirm Box']"));
        confirmAlertBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        WebElement resultMessage = driver.findElement(By.id("demo"));
        String expectedMessage = "You pressed Cancel!";

        if (expectedMessage.equals(resultMessage.getText())){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }

    }
}
