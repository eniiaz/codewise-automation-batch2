package guru;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ApplicationFlow;
import java.time.Duration;

public class BankLogin {

    public static void main(String[] args)  {
        Faker faker = new Faker();

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        WebElement input = driver.findElement(By.name("emailid"));
        input.sendKeys(faker.internet().emailAddress() + Keys.ENTER);
        WebElement userID = driver.findElement(By.xpath("(//td[@class='accpage'])[1]/../td[2]"));
        WebElement password = driver.findElement(By.xpath("(//td[@class='accpage'])[2]/../td[2]"));
        String userIDString = userID.getText();
        String passwordString = password.getText();
        ApplicationFlow.pause(500);
        driver.findElement(By.linkText("Bank Project")).click();
        driver.findElement(By.name("uid")).sendKeys(userIDString);
        driver.findElement(By.name("password")).sendKeys(passwordString);
        driver.findElement(By.name("btnLogin")).click();
        String expectedURL = "https://demo.guru99.com/V1/html/Managerhomepage.php";

        ApplicationFlow.pause(800);


        if (expectedURL.equals(driver.getCurrentUrl())){
            System.out.println("Bank Login is PASSED");
        }else{
            System.out.println("Bank Login is FAILED");
        }
        driver.quit();
    }
}
