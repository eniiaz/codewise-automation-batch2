package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {
        List<String> expectedDepartureCities = new ArrayList<>();
        expectedDepartureCities.add("Paris");
        expectedDepartureCities.add("Philadelphia");
        expectedDepartureCities.add("Boston");
        expectedDepartureCities.add("Portland");
        expectedDepartureCities.add("San Diego");
        expectedDepartureCities.add("Mexico City");
        expectedDepartureCities.add("São Paolo");

        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com");
        driver.manage().window().maximize();

        WebElement departureDropdown = driver.findElement(By.name("fromPort"));
        WebElement destinationDropdown = driver.findElement(By.name("toPort"));

        Select departureCities = new Select(departureDropdown);
        Select destinationCities = new Select(destinationDropdown);

        // Means, I have full access to interact with these two dropdowns
        String destinationDefaultValue = destinationCities.getFirstSelectedOption().getText();
        String departureDefaultValue = departureCities.getFirstSelectedOption().getText();

        System.out.println(departureDefaultValue);
        System.out.println(destinationDefaultValue);

        List<WebElement> departureOptions = departureCities.getOptions();
        System.out.println("All the option below");

        if (departureOptions.size() == expectedDepartureCities.size()){
            System.out.println("Departure city options size passed");
        }else{
            System.out.println("Departure city size failed");
        }

        for (WebElement option: departureOptions){
            if (expectedDepartureCities.contains(option.getText())){
                System.out.println("City passed");
            }else {
                System.out.println("City failed");
            }
        }

        departureCities.selectByVisibleText("Boston");
        Thread.sleep(500);
        departureCities.selectByIndex(4);
        Thread.sleep(500);
        departureCities.selectByValue("Mexico City");
    }

}
