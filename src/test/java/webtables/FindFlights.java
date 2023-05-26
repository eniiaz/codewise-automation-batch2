package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class FindFlights {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://www.blazedemo.com/reserve.php");
        driver.manage().window().maximize();

        for (WebElement flight: findFlights(200, 400)){
            System.out.println(flight.getText());
        }
    }

    public static List<WebElement> findFlights(double from, double to){
        List<WebElement> result = new ArrayList<>();
        List<WebElement> prices = driver.findElements(By.xpath("//tbody/tr/td[6]"));
        for (WebElement price: prices){
            String priceString = price.getText().replace("$", "");
            double priceDouble = Double.parseDouble(priceString);
            if (priceDouble >= from && priceDouble <= to){
                String xpath = "//tbody/tr//td[.='$" + priceDouble + "']/../td[2]";
                WebElement flight = driver.findElement(By.xpath(xpath));
                result.add(flight);
            }
        }
        return result;
    }

}
