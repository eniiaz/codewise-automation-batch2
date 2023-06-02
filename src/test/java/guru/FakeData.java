package guru;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FakeData {

    public static void main(String[] args) {
        Faker faker = new Faker();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        driver.manage().window().maximize();
        WebElement input = driver.findElement(By.name("emailid"));
        input.sendKeys(faker.internet().emailAddress() + Keys.ENTER);
        WebElement userID = driver.findElement(By.xpath("(//td[@class='accpage'])[1]/../td[2]"));
        WebElement password = driver.findElement(By.xpath("(//td[@class='accpage'])[2]/../td[2]"));

        System.out.println(userID.getText());
        System.out.println(password.getText());

    }
}
