package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sorting = new Select(sortDropdown);
        sorting.selectByValue("lohi");

        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < prices.size() - 1; i++){
            String tempPrice = prices.get(i).getText().replace("$", "");
            double priceDouble = Double.parseDouble(tempPrice);

            String tempPriceNext = prices.get(i+1).getText().replace("$", "");
            double priceDoubleNext = Double.parseDouble(tempPriceNext);

            if (priceDouble <= priceDoubleNext){
                System.out.println("Passed");
            }else {
                System.out.println("Failed");
            }
        }
    }
}
