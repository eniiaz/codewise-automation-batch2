package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class FindFlights {


    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://www.blazedemo.com/reserve.php");
        driver.manage().window().maximize();

        for (WebElement flight: findFlights(300, 500)){
            printFlightInfo(flight.getText());
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

    public static void printFlightInfo(String flightNumber){
        String xpathAirline = "//tbody/tr/td[.='"+ flightNumber + "']/../td[3]";
        String xpathDeparture = "//tbody/tr/td[.='"+ flightNumber + "']/../td[4]";
        String xpathArrival = "//tbody/tr/td[.='"+ flightNumber + "']/../td[5]";
        String xpathPrice = "//tbody/tr/td[.='"+ flightNumber + "']/../td[6]";
        System.out.println("\nFlight Info for: " + flightNumber);
        String airline = driver.findElement(By.xpath(xpathAirline)).getText();
        String departure = driver.findElement(By.xpath(xpathDeparture)).getText();
        String arrival = driver.findElement(By.xpath(xpathArrival)).getText();
        String price = driver.findElement(By.xpath(xpathPrice)).getText();

        System.out.println("Airline: " + airline);
        System.out.println("Departure: " + departure);
        System.out.println("Arrival: " + arrival);
        System.out.println("Price: " + price);
    }

}
