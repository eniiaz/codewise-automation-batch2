package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Art {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement testingTypeDropdown = driver.findElement(By.id("testingDropdown"));
        Select testingTypes = new Select(testingTypeDropdown);

        String actualDefaultOption = testingTypes.getFirstSelectedOption().getText();
        String expectedDefaultOption = "Automation Testing";

        if (expectedDefaultOption.equals(actualDefaultOption)){
            System.out.println("Default option passed\n");
        }else{
            System.out.println("Default option failed\n");
        }
        // Write a code that prints out all the options from testing types dropdown
        List<WebElement> allOptions = testingTypes.getOptions();
        for (WebElement option: allOptions){
            System.out.println(option.getText());
        }
        // Select Manual Testing from options
        testingTypes.selectByVisibleText("Manual Testing");
    }

}
